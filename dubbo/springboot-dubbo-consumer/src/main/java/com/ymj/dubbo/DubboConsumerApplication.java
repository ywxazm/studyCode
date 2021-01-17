package com.ymj.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.dubbo
 * @date 2020/8/24 9:00
 * @description
 */
@EnableDubboConfig
@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}