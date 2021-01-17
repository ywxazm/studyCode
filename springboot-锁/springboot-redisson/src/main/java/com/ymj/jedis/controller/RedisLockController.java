package com.ymj.jedis.controller;

import com.ymj.jedis.bean.UserDto;
import com.ymj.jedis.service.RedisLockService;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    private RedisLockService redisLockService;

    @RequestMapping("/testLock")
    public String testLock() throws InterruptedException {
        RLock rLock = redisLockService.lock("myLock");

        System.out.println("doing lock content... ...");
        Thread.sleep(500);

        redisLockService.release(rLock);

        return "success";
    }

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/put/{key}/{value}")
    public void put(@PathVariable("key") String key, @PathVariable("value") String value)  {
        int partition = key.hashCode() % 1024;
        RMapCache<String, String> map = redissonClient.getMapCache("map" + partition);
        map.put(key, "", 5, TimeUnit.DAYS);
    }

    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key") String key)  {
        int partition = key.hashCode() % 1024;
        RMap<String, String> map = redissonClient.getMap("map" + partition);
        String s = map.get(key);
        System.out.println(s);
        return s;
    }

}