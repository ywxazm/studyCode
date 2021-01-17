package com.ymj.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot
 * @date 2020/10/30 16:54
 * @description
 */
@MapperScan("com.ymj.boot.mapper")
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

}