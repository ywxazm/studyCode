package com.ymj.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ymj.dubbo.api.UserService;
import com.ymj.dubbo.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.dubbo.controller
 * @date 2020/8/24 9:35
 * @description
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        return userService.getUserInfo();
    }

    @RequestMapping("/getUserVo")
    public UserVo getUserVo() {
        return userService.getUserVo();
    }
}