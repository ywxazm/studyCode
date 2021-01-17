package com.ymj.consumer.ribbon;

import com.ymj.consumer.loadbalancer.MyRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer
 * @date 2020/8/10 19:31
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "eureka-provider", configuration = MyRandomRule.class)
public class EurekaConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}