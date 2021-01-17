package com.ymj.直接插入排序;

import com.ymj.create.Data;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.直接插入排序
 * @date 2020/8/25 9:03
 * @description
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {89, 45, 54, 29, 90, 34, 68};
        Data.print(arr);
        Sort.sort(arr);
        Data.print(arr);
    }

}