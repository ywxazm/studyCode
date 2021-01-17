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
 * @date 2020/10/29 9:07
 * @description
 */
@Rule(priority = 3)
public class Rule03 {

    @Condition
    public boolean condition(@Fact("list") List<String> list) {
        return list.contains("c");
    }

    @Action
    public void action(@Fact("list") List<String> list) {
        list.remove("c");
        list.add("cc");
        System.out.println("rule03, c -> cc");
    }

}