package com.ymj.nacos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.nacos
 * @date 2020/8/11 8:56
 * @description
 */
@RestController
public class NacosProviderController {

    @RequestMapping(value = "/echo/{s}")
    public String echo(@PathVariable String s) {
        return "Hello Nacos Discovery " + s;
    }

}