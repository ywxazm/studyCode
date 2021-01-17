package com.ymj.zk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.zk.controller
 * @date 2020/8/11 10:18
 * @description
 */
@RestController
public class ZKConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return restTemplate.getForObject("http://zk-provider/zk/hello?name=" + name, String.class);
    }

}