package com.ymj.kafka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.kafka.provider.controller
 * @date 2020/8/15 11:07
 * @description
 */
@RestController
public class KafkaProviderController {

    private static int i;

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public String send() {
        kafkaTemplate.send("ymjTopic", "msg = " + i++);
        return "msg: " + "msg = " + i + " , 已发送";
    }
}