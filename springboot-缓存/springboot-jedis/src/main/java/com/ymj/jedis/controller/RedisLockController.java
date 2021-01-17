package com.ymj.jedis.controller;

import com.ymj.jedis.util.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.controller
 * @date 2020/8/13 10:53
 * @description
 */
@RestController
public class RedisLockController {

    @Autowired
    private RedisServer redisServer;

    /* string */
    @RequestMapping("/setString")
    public void setString() {
        redisServer.set("user:login", "aaaaa");
        redisServer.set("user:out", "bbbbb");
    }

    /* list */
    @ResponseBody
    @RequestMapping("/setList")
    public void setList() {
        redisServer.lpush("myList", "a", "b", "c");
        redisServer.rpush("myList", "d", "e", "f");

        List<String> list01 = redisServer.lrange("myList", 0, 3);
        list01.forEach(System.out::print); //cbadef
        System.out.println();

        String ls01 = redisServer.lpop("myList");
        System.out.println(ls01);   //c
        String ls02 = redisServer.lpop("myList");
        System.out.println(ls02);   //b
        String rs01 = redisServer.rpop("myList");
        System.out.println(rs01);   //f
        String rs02 = redisServer.rpop("myList");
        System.out.println(rs02);   //e
    }

    /* set 去重 */
    @RequestMapping("/setSet")
    public void setSet() {
        redisServer.sadd("mySet","java", "c++", "delphi", "java");
        Set<String> mySet = redisServer.smembers("mySet");
        mySet.forEach(System.out::print);
    }

    /* zset 去重,排序 */
    @RequestMapping("/setZSet")
    public void setZSet() {
        redisServer.zadd("mySortedSet",50,"哪吒");
        redisServer.zadd("mySortedSet",90,"哪吒");    //scope为排序顺序
        redisServer.zadd("mySortedSet",70,"西游记");
        redisServer.zadd("mySortedSet",40,"红楼梦");

        //获取
        Set<String> mySortedSet = redisServer.zrangeByScore("mySortedSet", 0, 80);
        mySortedSet.forEach(System.out::print);
    }

    /* hash */
    @RequestMapping("/setHash")
    public void setHash() {
        redisServer.hset("myHash","a","111");
        redisServer.hset("myHash","b","222");
        redisServer.hset("myHash","c","333");

        String myHash = redisServer.hget("myHash", "a");
        System.out.println(myHash);

        Map<String, String> map = redisServer.hgetAll("myHash");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string+":"+map.get(string));
        }
    }

}