package com.ymj.直接插入排序;

import com.ymj.create.Data;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.直接插入排序
 * @date 2020/8/25 8:44
 * @description
 */
public class Sort {

    public static void sort(int[] arr) { //TODO 未完成
        for (int i = 1; i < arr.length; i++) {  //遍历未排序项
            int temp = arr[i];
            for (int j = i - 1; j < arr.length - 1; j++) {  //认为i-1项已排序
                if (arr[j] > temp) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                Data.print(arr);
            }
        }
    }

}