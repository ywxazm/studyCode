package com.ymj.rabbit.config;

import org.springframework.amqp.core.*;
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
public class TopicConfig {

    public static final String TOPIC_QUEUE = "topic.queue";
    public static final String TOPIC_EXCHANGE_NAME = "topic.exchange";
    public static final String TOPIC_ROUTING = "topic.routing";

    @Bean(name = TOPIC_QUEUE)
    public Queue createQueue() {
        return new Queue(TOPIC_QUEUE,false, false, true);
    }

    @Bean(name = TOPIC_EXCHANGE_NAME)
    TopicExchange createExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME,false,true);
    }

    @Bean(name = TOPIC_ROUTING)
    Binding binding() {
        return BindingBuilder.bind(createQueue()).to(createExchange()).with(TOPIC_ROUTING);
    }

}