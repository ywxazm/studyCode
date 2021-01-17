package com.ymj.mongodb.dao.impl;

import com.ymj.mongodb.dao.UserDao;
import com.ymj.mongodb.docment.UserDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.mongodb.dao.impl
 * @date 2020/8/14 14:35
 * @description
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save(UserDocument userDocument) {
        mongoTemplate.save(userDocument);
    }

    @Override
    public void delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserDocument.class);
    }

    @Override
    public void update(UserDocument userDocument) {
        Query query = new Query(Criteria.where("id").is(userDocument.getId()));
        Update update = new Update();
        update.set("name", userDocument.getName());
        update.set("age", userDocument.getAge());
        mongoTemplate.updateFirst(query, update, UserDocument.class);
    }

    @Override
    public UserDocument query(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, UserDocument.class);
    }

    private int age = 10000;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transaction() {
        Query query = new Query(Criteria.where("_id").is("3"));
        Update update = new Update();
//        update.set("age", age--);
        update.inc("age");
        mongoTemplate.updateFirst(query, update, UserDocument.class);
        System.out.println(Thread.currentThread().getName() + "=============执行更新: " + age);
//        int i = 10 / 0;


        /*mongoTemplate.dropCollection(UserDocument.class);
        UserDocument userDocument = new UserDocument();
        userDocument.setId("123");
        userDocument.setName("123sf");
        userDocument.setAge(22);
        mongoTemplate.save(userDocument);*/

//        int i = 10 / 0;

        /*for (int i = 10; i < 15; i++) {
            UserDocument userDocument = new UserDocument();
            userDocument.setId(String.valueOf(i - 10));
            userDocument.setName("123sf");
            userDocument.setAge(i);
            mongoTemplate.save(userDocument);
        }*/
    }
}