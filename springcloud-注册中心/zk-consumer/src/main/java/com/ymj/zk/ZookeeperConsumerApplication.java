package com.ymj.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.zk
 * @date 2020/8/11 10:17
 * @description
 */
@EnableFeignClients("com.ymj.zk.service")
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {        return new RestTemplate();
    }
}