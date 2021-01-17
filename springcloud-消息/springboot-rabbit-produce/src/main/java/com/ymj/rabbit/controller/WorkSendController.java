package com.ymj.rabbit.controller;

import com.ymj.rabbit.config.WorkConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rabbit.simple
 * @date 2020/10/10 10:47
 * @description
 */
@RestController
@RequestMapping("/work")
public class WorkSendController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/{msg}")
    public String send(@PathVariable("msg") String msg) {
        for (int count = 1; count <= 10; count++) {
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> infoMap = new HashMap<>();
            infoMap.put("queueName", WorkConfig.WORK_QUEUE);
            infoMap.put("messageId", String.valueOf(UUID.randomUUID()));
            infoMap.put("messageData", msg + "--" + count);
            infoMap.put("createTime", createTime);

            rabbitTemplate.convertAndSend(WorkConfig.WORK_QUEUE, infoMap);
        }
        return WorkConfig.WORK_QUEUE + "_消息发送成功";
    }


}