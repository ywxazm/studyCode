package com.ymj.provider.controller;

import com.ymj.provider.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.provider.controller
 * @date 2020/8/10 19:29
 * @description
 */
@RequestMapping("/helloController")
@RestController
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/getUser")
    public UserVo getUser() {
        UserVo userVo = new UserVo();
        userVo.setId("1");
        userVo.setName("xiaoming");
        userVo.setAge(19);
        return userVo;
    }
}