package com.ymj.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rule
 * @date 2020/10/29 9:06
 * @description
 */
@Rule(priority = 2)
public class Rule02 {

    @Condition
    public boolean condition(@Fact("list") List<String> list) {
        return list.contains("b");
    }

    @Action
    public void action(@Fact("list") List<String> list) {
        list.remove("b");
        list.add("bb");
        System.out.println("rule02, b -> bb");
    }

}