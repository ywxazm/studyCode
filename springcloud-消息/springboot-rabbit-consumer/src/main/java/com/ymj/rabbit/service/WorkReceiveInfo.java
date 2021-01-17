package com.ymj.rabbit.service;

import com.ymj.rabbit.config.WorkConfig;
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
public class WorkReceiveInfo {

    @RabbitHandler
    @RabbitListener(queues = WorkConfig.WORK_QUEUE)
    public void process01(Map<String,Object> testMessage) {
        System.out.println("Ymj01_Work接收到消息: " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = WorkConfig.WORK_QUEUE)
    public void process02(Map<String,Object> testMessage) {
        System.out.println("Ymj02_Work接收到消息: " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = WorkConfig.WORK_QUEUE)
    public void process03(Map<String,Object> testMessage) {
        System.out.println("Ymj03_Work接收到消息: " + testMessage);
    }

}