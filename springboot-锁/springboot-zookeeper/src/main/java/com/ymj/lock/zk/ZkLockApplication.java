package com.ymj.lock.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk
 * @date 2020/8/17 9:41
 * @description
 */
@SpringBootApplication
public class ZkLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkLockApplication.class, args);
    }

}