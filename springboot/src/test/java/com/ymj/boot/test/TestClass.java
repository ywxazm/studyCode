package com.ymj.boot.test;

import com.ymj.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.test
 * @date 2020/10/30 17:40
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private UserService userService;

    @Test
    public void list() {
        userService.list().forEach(System.out::println);
    }

    /* 测试---- 此处子线程会伴随主线程的结束而结束, 原因在于主线程结束, 则进行关闭, 子线程被迫结束 */
    @Test
    public void transactionOfMutliThread() throws InterruptedException {
        userService.transactionOfMutliThread();
    }

}