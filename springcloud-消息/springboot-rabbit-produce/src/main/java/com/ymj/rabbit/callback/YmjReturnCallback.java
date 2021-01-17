package com.ymj.rabbit.callback;

import com.rabbitmq.client.Return;
import com.rabbitmq.client.ReturnCallback;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit.callback
 * @date 2020/10/9 16:56
 * @description
 */
@Component
public class YmjReturnCallback implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息主体Msg: " + message);
        System.out.println("消息主体Msg: " + replyCode);
        System.out.println("描述: " + replyText);
        System.out.println("消息使用交换器: " + exchange);
        System.out.println("消息使用路由键: " + routingKey);
    }
}