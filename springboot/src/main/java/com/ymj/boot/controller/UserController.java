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

    @RequestMapping("/list")
    public List<UserDo> list() {
        return userService.list();
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody UserDo userDo) {
        return userService.insert(userDo);
    }

    @RequestMapping("/insertList")
    public int insert() {
        return userService.insertList();
    }

    @RequestMapping("/insertOrUpdate")
    public int insertOrUpdate(@RequestBody UserDo userDo) {
        return userService.insertOrUpdate(userDo);
    }

    @RequestMapping("/update01")
    public String update01(@RequestBody UserDo userDo) {
        String name = userDo.getName();
        long start = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            userDo.setName(name + i);
            userService.update(userDo);
        }
        System.out.println("update01耗时: " + (System.currentTimeMillis() - start));
        return "success";
    }

    @RequestMapping("/update02")
    public String update02(@RequestBody UserDo userDo) {
        String name = userDo.getName();
        long start = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            userDo.setName(name + i);
            userService.insertOrUpdate(userDo);
        }
        System.out.println("update02耗时: " + (System.currentTimeMillis() - start));
        return "success";
    }

    /**
    * @author ywx
    * @date 2020/11/4 15:17
    * @info 事务下的多线程
    */
    @RequestMapping("/transactionOfMutliThread")
    public String transactionOfMutliThread() throws InterruptedException {
        return userService.transactionOfMutliThread();
    }

    @RequestMapping("/rebase")
    public void rebase() {
        userService.rebase();
    }

    @RequestMapping("/OutOfMemoryError")
    public void OutOfMemoryError() {
        userService.OutOfMemoryError();
    }

}