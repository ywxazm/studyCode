package com.ymj.mongodb;

import com.ymj.mongodb.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.mongodb
 * @date 2020/11/11 6:19
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void transaction() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            Future<?> future = executorService.submit(new Thread(() -> {
                userDao.transaction();
            }));

            try {
                future.get();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
//        userDao.transaction();
    }
}