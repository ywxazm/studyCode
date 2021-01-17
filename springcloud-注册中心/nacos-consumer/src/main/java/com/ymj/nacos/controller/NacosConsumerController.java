package com.ymj.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.nacos.controller
 * @date 2020/8/11 9:19
 * @description
 */
@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/echo/{s}")
    public String echo(@PathVariable String s) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + s, String.class);
    }
}