package com.ymj.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ymj.boot.mapper.UserMapper;
import com.ymj.boot.pojo.ExecuteResult;
import com.ymj.boot.pojo.UserDo;
import com.ymj.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.service.impl
 * @date 2020/10/30 17:10
 * @description
 * 子线程发生异常, 不会被主线程发现, 若要发现子线程异常的方法有
 * 1.try...catch子线程代码, 记录下异常
 * 2.设置全局异常处理器
 * 3.Future获取返回信息, 得到异常
 *
 * 可以在主线程中用future.get()来捕获子线程的异常
 * 直接用this.*调用本类方法, 是不会有事务的, 需要用注入本类对象, 再调用才会有事务的回滚
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<UserDo> queryList(UserDo userDo) {
        return userMapper.queryList(userDo);
    }

    /* 数据库数据恢复 */
    @Override
    public void rebase() {
        UserDo userDo = new UserDo();
        userDo.setName("黄龙飞");
        List<UserDo> list = userService.queryList(userDo);

        list.forEach(item -> {
            String info = item.getInfo();
            UserDo u = JSONObject.parseObject(info, UserDo.class);
            item.setAge(u.getAge());
            userService.update(item);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(UserDo userDo) {
        return userMapper.update(userDo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchUpdate(List<UserDo> userDoList) {
        return userMapper.batchUpdate(userDoList);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public int forkJoinBatchUpdate(List<UserDo> userDoList) {

        ExecutorTask executorTask = new ExecutorTask(userDoList);
        ExecuteResult executeResult = executorTask.invoke();

        if (!executeResult.getResult()) {
            throw new RuntimeException(JSONObject.toJSONString(executeResult.getErrorInfoList()));
        }

        return executeResult.getSuccessIdList().size();
    }

    class ExecutorTask extends RecursiveTask<ExecuteResult> {

        /** 更新语句一次执行数量 */
        private static final int PROCESS_NUM = 500;

        /** 待更新数据 */
        private List<UserDo> userDoList;

        /** 开始索引 */
        private int startIndex;

        /** 结束索引 */
        private int endIndex;

        public ExecutorTask(List<UserDo> userDoList) {
            this.userDoList = userDoList;
            startIndex = 0;
            endIndex = userDoList.size();
        }

        @Override
        public ExecuteResult compute() {
            ExecuteResult executeResult = new ExecuteResult();

            if (endIndex - startIndex < PROCESS_NUM) {
                int updateCount = userMapper.batchUpdate(userDoList);

                if (updateCount == userDoList.size()) {
                    executeResult.getSuccessIdList().addAll(userDoList.stream().map(UserDo::getId).collect(Collectors.toList()));
                    executeResult.setResult(true);
                } else {
                    executeResult.getErrorInfoList().add("已更新数量 < 待更新数量");
                    executeResult.setResult(false);
                }
            } else {
                int middle = (startIndex + endIndex) / 2;

                List<UserDo> left = userDoList.subList(startIndex, middle);
                List<UserDo> right = userDoList.subList(middle, endIndex);

                ExecutorTask leftTask = new ExecutorTask(left);
                ExecutorTask rightTask = new ExecutorTask(right);

                invokeAll(leftTask, rightTask);

                executeResult.addResult(leftTask.join());
                executeResult.addResult(rightTask.join());
            }

            return executeResult;
        }
    }

}