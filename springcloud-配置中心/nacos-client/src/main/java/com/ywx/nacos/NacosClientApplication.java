package com.ywx.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.nacos
 * @date 2020/8/12 17:00
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
public class NacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }

}