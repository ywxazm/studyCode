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
public class FanoutConfig {

    public static final String FANOUT_QUEUE_01 = "fanout.queue.01";
    public static final String FANOUT_QUEUE_02 = "fanout.queue.02";
    public static final String FANOUT_QUEUE_03 = "fanout.queue.03";
    public static final String FANOUT_EXCHANGE_NAME = "fanout.exchange";

    @Bean(name = FANOUT_QUEUE_01)
    public Queue createQueue01() {
        return new Queue(FANOUT_QUEUE_01,false, false, true);
    }

    @Bean(name = FANOUT_QUEUE_02)
    public Queue createQueue02() {
        return new Queue(FANOUT_QUEUE_02,false, false, true);
    }

    @Bean(name = FANOUT_QUEUE_03)
    public Queue createQueue03() {
        return new Queue(FANOUT_QUEUE_03,false, false, true);
    }

    @Bean(name = FANOUT_EXCHANGE_NAME)
    FanoutExchange createExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME,false,true);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(createQueue01()).to(createExchange());
    }

}