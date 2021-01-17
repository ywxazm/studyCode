package com.ymj.jedis.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.exception
 * @date 2020/8/13 10:48
 * @description
 */
@AllArgsConstructor
@Data
public class RedissonException extends RuntimeException {

    /* 异常编码 */
    private int code;

    /* 异常信息 */
    private String message;

    public RedissonException(RedisExceptionEnum redisExceptionEnum) {
        this.code = redisExceptionEnum.getCode();
        this.message = redisExceptionEnum.getMessage();
    }

}