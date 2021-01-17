package com.ymj.jedis.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.jedis.util
 * @date 2020/9/16 9:48
 * @description
 */
@Configuration
public class JedisPoolUtil {

    @Value("${spring.redis.host}")
    private String ip;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        return new JedisPool(config, ip, port, timeout);
    }

    @Bean
    public Jedis getJedis() {
        return this.getJedisPool().getResource();
    }
}