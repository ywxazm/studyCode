package com.ywx.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.nacos.controller
 * @date 2020/8/12 17:05
 * @description
 */
@RefreshScope
@RestController
public class NacosController {

    @Value("${name}")
    private String name;

    @RequestMapping("/info")
    public String info() {
        return name;
    }
}