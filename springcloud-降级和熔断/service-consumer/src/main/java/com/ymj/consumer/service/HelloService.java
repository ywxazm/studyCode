package com.ymj.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer.feign.service
 * @date 2020/8/11 16:08
 * @description
 */
@FeignClient(value = "SERVICE-PROVIDER")
@RequestMapping("/helloController")
public interface HelloService {

    @RequestMapping("/say")
    String sayHello();

    @RequestMapping("/npe")
    String npe();

    @RequestMapping("/timeout")
    String timeout();

}