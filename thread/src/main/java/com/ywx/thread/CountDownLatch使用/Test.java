package com.ywx.thread.CountDownLatch使用;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.thread.CountDownLatch使用
 * @date 2020/11/13 13:59
 * @description
 * await() throws InterruptedException：调用该方法的线程等到构造方法传入的 N 减到 0 的时候，才能继续往下执行；
 * await(long timeout, TimeUnit unit)：与上面的 await 方法功能一致，只不过这里有了时间限制，调用该方法的线程等到指定的 timeout 时间后，不管 N 是否减至为 0，都会继续往下执行；
 * countDown()：使 CountDownLatch 初始值 N 减 1；
 * long getCount()：获取当前 CountDownLatch 维护的值
 */
public class Test {

    private static final int WAIT_NUM = 100;

    public static void main(String[] args)  {

        CountDownLatch countDownLatch = new CountDownLatch(WAIT_NUM);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= WAIT_NUM; i++) {
            executorService.submit(new Thread(() -> {
                System.out.println("-----------------开始");
                countDownLatch.countDown();
            }));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------结束");
    }


}