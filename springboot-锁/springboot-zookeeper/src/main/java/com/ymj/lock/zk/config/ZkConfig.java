package com.ymj.lock.zk.config;

import com.ymj.lock.zk.watch.ZkWatch;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk.config
 * @date 2020/8/17 10:24
 * @description
 */
@Configuration
public class ZkConfig {
    
    @Value("${zk.addr}")
    private String zkServerAddr;

    @Value("${zk.port}")
    private int port;

    @Value("${zk.timeout}")
    private int timeout;

    @Autowired
    private ZkWatch zkWatch;

    @Bean
    public ZooKeeper zooKeeper() {
        try {
            return new ZooKeeper(zkServerAddr + ":" + port, timeout, zkWatch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}