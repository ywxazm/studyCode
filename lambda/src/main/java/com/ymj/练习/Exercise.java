package com.ymj.练习;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.练习
 * @date 2020/9/25 15:33
 * @description
 */
public class Exercise {

    private static final Trader raoul = new Trader("Raoul", "Cambridge");
    private static final Trader mario = new Trader("Mario","Milan");
    private static final Trader alan = new Trader("Alan","Cambridge");
    private static final Trader brian = new Trader("Brian","Cambridge");

    private static final List<Transaction> transactionList = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        /*找出2011年发生的所有交易，并按交易额排序*/
        transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("-------------");
        /*
        * 等价于:  transactionList.stream().filter(t -> t.getYear() == 2011).sorted((v1, v2) -> v1.getValue() - v2.getValue()).forEach(System.out::println);
         *  */

        /*交易员在哪些不同的城市工作过*/
        transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------------");

        /*查找所有来自剑桥的交易员，并按姓名排序*/
        transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
        System.out.println("-------------");

        /*返回所有交易员的姓名字符串，并按字母顺序排序*/
        transactionList.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted((t1, t2) -> t1.compareTo(t2))
                .forEach(System.out::println);
        System.out.println("-------------");

        /*有没有交易员在米兰工作的*/
        transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Milan"))
                .forEach(System.out::println);
        System.out.println("-------------");

        /*打印生活在剑桥的交易员的所有交易额*/
        /*transactionList.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map*/

        /*所有交易中，最高的交易额是多少*/
        Integer max = transactionList.stream()
                .map(Transaction::getValue)
                .max((v1, v2) -> v1 - v2)
                .get();
        System.out.println("最高交易额:" + max);
        System.out.println("-------------");

        /*找到交易额最小的交易*/
        Integer min = transactionList.stream()
                .map(Transaction::getValue)
                .min((v1, v2) -> v1 - v2)
                .get();
        System.out.println("最低交易额:" + min);
        System.out.println("-------------");

        /* 找到最高交易额的交易员 */
        Trader trader = transactionList.stream()
                .max((t1, t2) -> t1.getValue() - t2.getValue())
                .map(Transaction::getTrader)
                .get();
        System.out.println(trader);
        System.out.println("-------------");

        /* 统计2012年每个人的交易金额 */
        Map<String, Integer> sumValue = transactionList.stream()
                .filter(t -> t.getYear() == 2012)
                .collect(Collectors.groupingBy(t -> t.getTrader().getName(), Collectors.summingInt(Transaction::getValue)));
        System.out.println(sumValue);
        System.out.println("-------------");

        /* 将交易员信息转为Map集合 */
        Map<String, Trader> map = transactionList.stream()
                .map(Transaction::getTrader)
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .collect(Collectors.toMap(Trader::getName, vo -> vo));
        System.out.println(map);
        System.out.println("-------------");
    }
}




@AllArgsConstructor
@NoArgsConstructor
@Data
class Trader{
    private String name;
    private String city;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Transaction{
    private Trader trader;
    private int year;
    private int value;
}