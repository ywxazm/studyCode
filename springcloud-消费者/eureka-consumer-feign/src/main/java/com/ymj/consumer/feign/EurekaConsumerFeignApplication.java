package com.ymj.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer
 * @date 2020/8/10 19:31
 * @description
 */
@EnableFeignClients("com.ymj.consumer.feign.service")
@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignApplication.class, args);
    }

}