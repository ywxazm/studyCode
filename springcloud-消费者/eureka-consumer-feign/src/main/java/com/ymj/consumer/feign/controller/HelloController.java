package com.ymj.consumer.feign.controller;

import com.ymj.consumer.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

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
    private HelloService helloService;

    @RequestMapping("/say")
    public String say() {
        return helloService.sayHello();
    }

}