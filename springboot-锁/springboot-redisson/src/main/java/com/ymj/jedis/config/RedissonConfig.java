package com.ymj.jedis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.config
 * @date 2020/8/13 10:58
 * @description
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:1005");
        config.setCodec(StringCodec.INSTANCE);
        return Redisson.create(config);
    }

}