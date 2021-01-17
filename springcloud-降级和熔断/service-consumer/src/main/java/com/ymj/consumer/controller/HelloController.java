package com.ymj.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ymj.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer.controller
 * @date 2020/8/10 19:35
 * @description
 */
@RestController
public class HelloController {

    private static int count = 0;

    private static int timeoutCount = 0;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/say")
    public String say() {
        return helloService.sayHello();
    }

    @RequestMapping("/npe")
    public String npe() {
        System.out.println("npe被调用-----------" + ++count +"-------------");
        return helloService.npe();
    }

    @HystrixCommand(
            commandKey = "createOrder",
            commandProperties = {@HystrixProperty(name="execution.timeout.enabled", value="true"),  //开启超时降级
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000"),    //3秒
            },
            fallbackMethod = "timeoutDownLevel")   //回调方法
    @RequestMapping("/timeout")
    public String timeout() {
        System.out.println("timeout被调用-----------" + ++timeoutCount +"-------------");
        return helloService.timeout();
    }

    @HystrixCommand(
            commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")},    //线程池模式
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "3"),   //核心线程数
                    @HystrixProperty(name = "maxQueueSize", value = "0")},   //队列大小
            fallbackMethod = "fixedThreadDownLevel")
    @RequestMapping("/fixedThread")
    public String fixedThread() {       //核心线程数和并发请求数指的都是调用注解的方法执行的线程
        System.out.println("=================" + Thread.currentThread().getName());
        return helloService.timeout();
    }

    @HystrixCommand(
            commandProperties= {@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),   //信号量模式
                    @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests", value="3")},   //并发请求数
            fallbackMethod = "currentNumDownLevel")
    @RequestMapping("/currentNum")
    public String currentNum() {        //核心线程数和并发请求数指的都是调用注解的方法执行的线程
        System.out.println("=================" + Thread.currentThread().getName());
        return helloService.timeout();
    }

    /* 超时降级方法 */
    public String timeoutDownLevel() {
        return "-----------------超时降级-------------------";
    }

    /* 线程池降级方法 */
    public String fixedThreadDownLevel() {
        System.out.println("-----------------固定线程数降级-------------------");
        return "-----------------固定线程数降级-------------------";
    }

    /* 固定信号量降级方法 */
    public String currentNumDownLevel() {
        System.out.println("-----------------固定信号量降级-------------------");
        return "-----------------固定信号量降级-------------------";
    }
}