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
public class WorkConfig {

    public static final String WORK_QUEUE = "work.queue";

    @Bean(name = WORK_QUEUE)
    public Queue createQueue() {
        return new Queue(WORK_QUEUE,false, false, true);
    }
}