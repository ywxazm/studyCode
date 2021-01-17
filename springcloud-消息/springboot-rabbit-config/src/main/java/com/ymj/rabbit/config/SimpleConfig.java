package com.ymj.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit.config
 * @date 2020/10/10 10:38
 * @description
 */
@Configuration
public class SimpleConfig {

    public static final String SIMPLE_QUEUE = "simple.queue";

    @Bean(name = SIMPLE_QUEUE)
    public Queue createQueue() {
        return new Queue(SIMPLE_QUEUE,false, false, true);
    }
}