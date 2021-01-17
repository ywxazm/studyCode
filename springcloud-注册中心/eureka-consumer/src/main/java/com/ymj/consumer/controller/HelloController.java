package com.ymj.consumer.controller;

import com.ymj.consumer.service.HelloService;
import com.ymj.consumer.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/getUser")
    public UserVo getUser() {
        return helloService.getUser();
    }
}