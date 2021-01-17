package com.ymj.基本语法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.基本语法
 * @date 2020/9/25 10:37
 * @description
 */
public class User_Param {

    private static final String[] nameArr = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer","Roger Federer",
            "Andy Murray","Tomas Berdych",
            "Juan Martin Del Potro"};

    private static final List<String> nameList =  Arrays.asList(nameArr);

    public static void main(String[] args) {
        nameList.sort(Comparator.comparingInt((String s) -> s.charAt(0)));
        /* 等价于
        nameList.sort((String s1, String s2) -> {
            return s1.charAt(0) - s2.charAt(0);
        });
        *  */
        nameList.forEach(s -> System.out.println(s + ", "));
    }
}