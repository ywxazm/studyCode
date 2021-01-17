package com.ymj.基本语法;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.基本语法
 * @date 2020/9/25 10:15
 * @description
 */
public class User_Foreach {

    private static final String[] nameArr = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer","Roger Federer",
            "Andy Murray","Tomas Berdych",
            "Juan Martin Del Potro"};

    private static final List<String> nameList =  Arrays.asList(nameArr);

    public static void main(String[] args) {
        nameList.forEach(System.out::println); //等价于 nameList.forEach(name -> System.out.println(name));
    }
}