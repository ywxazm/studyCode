package com.ymj.rule;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.rule
 * @date 2020/10/28 17:38
 * @description
 */
public class RuleClient {

    public static void main(String[] args) {
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(false);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

        Rules rules = new Rules();
        rules.register(new Rule01());
        rules.register(new Rule02());
        rules.register(new Rule03());

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Facts facts = new Facts();
        facts.put("list", list);

        rulesEngine.fire(rules, facts);

        list.forEach(System.out::println);
    }

}