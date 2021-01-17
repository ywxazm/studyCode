package com.ymj.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Bean
    MongoTransactionManager transactionManager(MongoTemplate mongoTemplate){
    	System.out.println("====================================================================================");
        return new MongoTransactionManager(mongoTemplate.getMongoDbFactory());
    }
}



