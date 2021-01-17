package com.ymj.create;

import java.util.Random;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.create
 * @date 2020/8/24 19:23
 * @description
 */
public class Data {

    public static int[] createDate(int round) {
        int[] arr = new int[round];
        for (int i = 1; i < round; i++) {
            arr[i] = new Random().nextInt(round * 10);
        }
        return arr;
    }

    public static void print(int[] arr) {
       for (int i = 0; i < arr.length; i++) {
           if (i == arr.length - 1) {
               System.out.print(arr[i]);
           }else {
               System.out.print(arr[i] + ", ");
           }
       }
        System.out.println();
    }

}