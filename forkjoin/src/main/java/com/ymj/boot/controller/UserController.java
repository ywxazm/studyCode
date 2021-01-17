package com.ymj.boot.controller;

import com.ymj.boot.pojo.UserDo;
import com.ymj.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.controller
 * @date 2020/10/30 17:05
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/rebase")
    public void rebase() {
        userService.rebase();
    }

}