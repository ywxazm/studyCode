package com.ymj.kafka.consumer.listener;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import javax.servlet.annotation.WebListener;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.kafka.consumer.listener
 * @date 2020/8/15 14:01
 * @description
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "ymjTopic", groupId = "testGroup")
    public void onMessage(String message){
        System.out.println("消费消息: " + message);
    }

}