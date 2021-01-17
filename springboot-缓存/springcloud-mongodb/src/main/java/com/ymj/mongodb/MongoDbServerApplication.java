package com.ymj.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author ywx
 * @version V1.0
 * @package com.ywx.nacos
 * @date 2020/8/12 17:00
 * @description
 */
@EnableTransactionManagement
@SpringBootApplication
public class MongoDbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbServerApplication.class, args);
    }

}