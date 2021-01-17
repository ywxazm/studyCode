package com.ymj.rabbit.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit.callback
 * @date 2020/10/9 16:02
 * @description
 */
@Component
public class YmjConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("消息唯一标识" + correlationData);
        System.out.println("确认结果" + ack);
        System.out.println("失败原因" + cause);
    }
}