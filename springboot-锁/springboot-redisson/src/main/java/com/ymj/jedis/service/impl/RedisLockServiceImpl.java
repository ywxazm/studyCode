package com.ymj.jedis.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ymj.jedis.exception.RedisExceptionEnum;
import com.ymj.jedis.exception.RedissonException;
import com.ymj.jedis.service.RedisLockService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.service.impl
 * @date 2020/8/13 10:41
 * @description
 */
@Slf4j
@Service
public class RedisLockServiceImpl implements RedisLockService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String lockPath) {
        /* 公平锁 */
        RLock fairLock = redissonClient.getFairLock(lockPath);
        if (!fairLock.tryLock()) {
            log.error("Thread = {} lock fail, current time = {}, lock value = {}", Thread.currentThread(),
                    System.currentTimeMillis(), lockPath);
            throw new RedissonException(RedisExceptionEnum.LOCK_FAIL);
        }
        return fairLock;
    }

    @Override
    public RLock lockAndAutoUnLock(String lockPath) throws InterruptedException {
        /* 公平锁 */
        RLock fairLock = redissonClient.getFairLock(lockPath);
        /* 120秒以后自动解锁 */
        if (!fairLock.tryLock(120, TimeUnit.SECONDS)) {
            log.error("Thread = {} lock fail, current time = {}, lock value = {}", Thread.currentThread(),
                    System.currentTimeMillis(), lockPath);
            throw new RedissonException(RedisExceptionEnum.LOCK_FAIL);
        }
        return fairLock;


    }

    @Override
    public void release(RLock rLock) {
        try {
            if (ObjectUtil.isNotNull(rLock) && rLock.isLocked()) {
                rLock.unlock();
            }
        } catch (Exception e) {
            log.error("Thread = {} lock fail, current time = {}, error info = {}", Thread.currentThread(),
                    System.currentTimeMillis(), e.getMessage());
        } finally {
            rLock.unlock();
        }
    }

}