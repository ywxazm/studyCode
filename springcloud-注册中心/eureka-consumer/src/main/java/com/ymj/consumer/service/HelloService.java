package com.ymj.consumer.service;

import com.ymj.consumer.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer.service
 * @date 2020/8/10 19:35
 * @description
 */
@FeignClient("eureka-provider")
@RequestMapping("/helloController")
public interface HelloService {

    @RequestMapping("/sayHello")
    String sayHello();

    @RequestMapping("/getUser")
    UserVo getUser();
}