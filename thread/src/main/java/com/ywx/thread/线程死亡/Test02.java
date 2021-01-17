package com.ywx.thread.线程死亡;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.thread.线程死亡
 * @date 2020/11/4 10:49
 * @description 主线程死亡, 子线程正常执行
 */
public class Test02 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i < 100000; i++) {
                System.out.println("当前线名: " + Thread.currentThread().getName() + ", i = " + i);
            }
        });

        t.setDaemon(false); //设置为非守护线程
        t.start();

        System.out.println("主线程结束...");
    }
}