package com.ymj.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer.controller
 * @date 2020/8/10 19:35
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/say")
    public String say() {
        return restTemplate.getForObject("http://eureka-provider/helloController/sayHello", String.class);
    }
}