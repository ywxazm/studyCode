package com.ymj.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.zk
 * @date 2020/8/11 10:17
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperProviderApplication.class, args);
    }

}