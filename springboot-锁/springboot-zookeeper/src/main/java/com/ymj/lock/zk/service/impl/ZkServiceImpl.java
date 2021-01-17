package com.ymj.lock.zk.service.impl;

import com.ymj.lock.zk.service.ZkService;
import com.ymj.lock.zk.watch.ZkWatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk.service.impl
 * @date 2020/8/17 10:16
 * @description
 */
@Service
public class ZkServiceImpl implements ZkService {

    @Autowired
    private ZooKeeper zooKeeper;
    @Autowired
    private ZkWatch zkWatch;

    /** 尝试获取锁 */
    @Override
    public boolean lock(String guidNodeName, String clientGuid) throws KeeperException, InterruptedException {
        boolean result = false;
        if (zooKeeper.exists(guidNodeName, zkWatch) == null) {
            zooKeeper.create(guidNodeName, clientGuid.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            byte[] data = zooKeeper.getData(guidNodeName, false, null);
            if (data != null && clientGuid.equals(new String(data))) {
                result = true;
            }
        }
        return result;
    }

    /** 释放锁 */
    @Override
    public boolean release(String guidNodeName, String clientGuid) throws KeeperException, InterruptedException {
        boolean result = false;
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData(guidNodeName, false, stat);
        if (data != null && clientGuid.equals(new String(data))) {
            zooKeeper.delete(guidNodeName, stat.getVersion());
            result = true;
        }
        return result;
    }

    /** 锁是否已经存在 */
    @Override
    public boolean exists(String guidNodeName) throws KeeperException, InterruptedException {
        return zooKeeper.exists(guidNodeName, false) != null;
    }

}