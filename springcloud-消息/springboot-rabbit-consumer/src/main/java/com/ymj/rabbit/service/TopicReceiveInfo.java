package com.ymj.rabbit.service;

import com.ymj.rabbit.config.TopicConfig;
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
public class TopicReceiveInfo {

    @RabbitHandler
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE)
    public void process(Map<String,Object> testMessage) {
        System.out.println("Ymj_Topic接收到消息: " + testMessage);
    }

}