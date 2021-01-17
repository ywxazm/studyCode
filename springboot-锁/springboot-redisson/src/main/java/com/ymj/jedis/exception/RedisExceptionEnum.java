package com.ymj.jedis.exception;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.redisson.exception
 * @date 2020/8/13 13:49
 * @description
 */
public enum  RedisExceptionEnum {

    LOCK_FAIL(1001, "加锁失败");

    /* 异常编码 */
    private int code;

    /* 异常信息 */
    private String message;

    RedisExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}