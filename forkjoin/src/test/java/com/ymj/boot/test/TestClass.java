package com.ymj.boot.test;

import com.ymj.boot.pojo.UserDo;
import com.ymj.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.test
 * @date 2020/10/30 17:40
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private UserService userService;

    @Test
    public void batchUpdate() {
        UserDo userDo = new UserDo();
        userDo.setName("黄龙飞");
        List<UserDo> userDoList = userService.queryList(userDo);

        long startTime = System.currentTimeMillis();
        int updateCount = userService.forkJoinBatchUpdate(userDoList);
        long endTime = System.currentTimeMillis();
        System.out.println("-------------------更新数: " + updateCount);
        System.out.println("-------------------耗时: " + (endTime - startTime));
    }

}