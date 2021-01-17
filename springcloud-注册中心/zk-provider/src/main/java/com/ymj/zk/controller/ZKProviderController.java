package com.ymj.zk.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.zk.controller
 * @date 2020/8/11 10:18
 * @description
 */
@RestController
@RequestMapping("/zk")
public class ZKProviderController {

    @RequestMapping(value = "/hello")
    public String sayHello(String name) {
        return "hello: " + name;
    }

}