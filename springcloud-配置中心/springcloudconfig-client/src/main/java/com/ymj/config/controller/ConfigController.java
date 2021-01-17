package com.ymj.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.config.controller
 * @date 2020/8/11 19:15
 * @description
 */
@RestController
public class ConfigController {

    @Value("${name}")
    private String name;

    @Value("${total}")
    private String total;

    @RequestMapping("/info")
    public String info() {
        return "name: " + name + ", total: " + total;
    }
}