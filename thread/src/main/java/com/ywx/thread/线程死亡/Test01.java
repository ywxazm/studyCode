package com.ywx.thread.线程死亡;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.thread.线程死亡
 * @date 2020/11/4 10:45
 * @description 守护线程伴随用户线程死亡
 */
public class Test01 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i < 100000; i++) {
                System.out.println("当前线名: " + Thread.currentThread().getName() + ", i = " + i);
            }
        });

        t.setDaemon(true); //设置为守护线程
        t.start();

        System.out.println("主线程结束...");
    }

}