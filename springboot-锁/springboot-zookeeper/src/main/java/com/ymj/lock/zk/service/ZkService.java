package com.ymj.lock.zk.service;

import org.apache.zookeeper.KeeperException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk.service
 * @date 2020/8/17 10:14
 * @description
 */
public interface ZkService {

    boolean lock(String guidNodeName, String clientGuid) throws KeeperException, InterruptedException;

    boolean release(String guidNodeName, String clientGuid) throws KeeperException, InterruptedException;

    boolean exists(String guidNodeName) throws KeeperException, InterruptedException;

}