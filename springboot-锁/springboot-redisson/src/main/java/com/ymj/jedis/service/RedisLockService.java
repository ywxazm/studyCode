package com.ymj.jedis.service;

import org.redisson.api.RLock;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.service
 * @date 2020/8/13 10:40
 * @description
 */
public interface RedisLockService {

    RLock lock(String lockPath);

    RLock lockAndAutoUnLock(String lockPath) throws InterruptedException;

    void release(RLock rLock);
}