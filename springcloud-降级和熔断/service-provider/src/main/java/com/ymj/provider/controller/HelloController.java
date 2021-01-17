package com.ymj.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.provider.controller
 * @date 2020/8/10 19:29
 * @description
 */
@RestController
@RequestMapping("/helloController")
public class HelloController {

    private static int count = 0;
    private static int timeoutCount = 0;

    @RequestMapping("/say")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/npe")
    public String npe() {
        System.out.println("npe-----------" + ++count +"-------------");
        throw new NullPointerException("空指针异常");
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        System.out.println("timeout被调用-----------" + ++timeoutCount +"-------------");
        Thread.sleep(100000);
        return "Time = 100000";
    }

}