package com.ymj.rabbit.service;

import com.ymj.rabbit.config.FanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit
 * @date 2020/8/17 15:35
 * @description
 */
@Component
public class FanoutReceiveInfo {

    @RabbitHandler
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_01)
    public void process01(Map<String,Object> testMessage) {
        System.out.println("Ymj_Fanout_Queue01接收到消息: " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_02)
    public void process02(Map<String,Object> testMessage) {
        System.out.println("Ymj_Fanout_Queue02接收到消息: " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_03)
    public void process03(Map<String,Object> testMessage) {
        System.out.println("Ymj_Fanout_Queue03接收到消息: " + testMessage);
    }

}