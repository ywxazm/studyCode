package com.ywx.thread.线程死亡;

import java.util.Date;

/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.thread.线程死亡
 * @date 2020/12/1 9:43
 * @description
 */
public class JVMExit {

    public static void main(String[] args) {

        new Thread(() -> {
            for (;;) {
                System.out.println(new Date());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().exit(0);
    }
}