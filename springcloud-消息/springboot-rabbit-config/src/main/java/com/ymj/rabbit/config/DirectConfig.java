package com.ymj.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
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
public class DirectConfig {

    public static final String DIRECT_QUEUE = "direct.queue";
    public static final String DIRECT_EXCHANGE_NAME = "direct.exchange";
    public static final String DIRECT_ROUTING_KEY = "direct.routing.key";

    @Bean(name = DIRECT_QUEUE)
    public Queue createQueue() {
        return new Queue(DIRECT_QUEUE,false, false, true);
    }

    @Bean(name = DIRECT_EXCHANGE_NAME)          //不带名字, 默认使用自带的交换器
    DirectExchange createExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME,false,true);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(createQueue()).to(createExchange()).with(DIRECT_ROUTING_KEY);
    }

}