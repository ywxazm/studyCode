package com.ywx.thread.CyclicBarrier使用;

import java.util.concurrent.*;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.thread.CyclicBarrier使用
 * @date 2020/11/13 14:00
 * @description
 *  *  等到所有的线程都到达指定的临界点 await() throws InterruptedException, BrokenBarrierException
 *  * 与上面的await方法功能基本一致，只不过这里有超时限制，阻塞等待直至到达超时时间为止 await(long timeout, TimeUnit unit) throws InterruptedException, BrokenBarrierException, TimeoutException
 *  * 获取当前有多少个线程阻塞等待在临界点上 int getNumberWaiting()
 *  * 用于查询阻塞等待的线程是否被中断 boolean isBroken()
 */
public class Test {

    private static final int WAIT_NUM = 100;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(WAIT_NUM, () -> {
            System.out.println("-----------------结束");
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= WAIT_NUM; i++) {
            executorService.submit(new Thread(() -> {
                System.out.println("-----------------开始");
                try {
                    cyclicBarrier.await();
                    System.out.println("-----------撒花");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));
        }
    }

}