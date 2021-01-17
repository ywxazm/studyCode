package com.ymj.基本语法;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.基本语法
 * @date 2020/9/25 11:13
 * @description
 */
public class User_Interface {

    private static final String[] nameArr = {
            "Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer","Roger Federer",
            "Andy Murray","Tomas Berdych",
            "Juan Martin Del Potro"};

    private static final List<String> nameList =  Arrays.asList(nameArr);

    public static void main(String[] args) {
        /* Consumer的使用 */
        Consumer<String> consumer = t -> System.out.println(t + ", ");
        nameList.forEach(consumer);
        System.out.println("------------------");

        /* Predicate的使用 */
        Predicate<String> predicate = t -> t.contains("J");
        nameList.stream().filter(predicate).forEach(System.out::println);
        System.out.println("------------------");

        /* Function的使用 */
        Function<String, String> function_key = Function.identity();
        Function<String, Integer> function_value = String::length;
        Map<String, Integer> map = nameList.stream().collect(Collectors.toMap(function_key, function_value));
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s + " = " + map.get(s));
        }
        System.out.println("------------------");

    }

}