package com.ymj.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit
 * @date 2020/8/17 15:26
 * @description
 */
@EnableRabbit
@SpringBootApplication
public class RabbitProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProduceApplication.class, args);
    }

}