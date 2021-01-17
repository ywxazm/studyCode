package com.ymj.基本语法;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.基本语法
 * @date 2020/9/25 10:34
 * @description 无入参的使用
 */
public class User_NoParam {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("--runnable--");
        Thread thread = new Thread(runnable);
        thread.start();
    }
}