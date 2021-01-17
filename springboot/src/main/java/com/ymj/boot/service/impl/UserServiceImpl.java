package com.ymj.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ymj.boot.mapper.UserMapper;
import com.ymj.boot.pojo.UserDo;
import com.ymj.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.*;

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
    public List<UserDo> list() {
        return userMapper.list();
    }

    @Override
    public List<UserDo> queryList(UserDo userDo) {
        return userMapper.queryList(userDo);
    }

    /* 数据库存数据恢复 */
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
    public int insert(UserDo userDo) {
        return userMapper.insert(userDo);
    }

    /* 数据库存数据生成 */
    @Override
    public int insertList() {
        String[] first = {"赵","钱","孙","李","郑","王","欧","宇文","欧阳","朱","成","陈","黄","司马","蒋","荀","宋","楚","项"};
        String[] mid =   {"博","雨","裕","雅","闻","容","艺","微","尉","存","军","学","峰","祖","龙","介","石","汉","泽"};
        String[] last =  {"德","晖","芳","旭","飞","轩","华","菲","同","畅","浩","然","紫","贞","飞","东","伟","恒","荣"};
        for (int i = 1; i <= 5000000; i++) {
            UserDo userDo = new UserDo();
            userDo.setId(String.valueOf(UUID.randomUUID()).replace("-", ""));
            userDo.setAge(String.valueOf(new Random().nextInt(100)));
            userDo.setName(first[new Random().nextInt(18)] + mid[new Random().nextInt(18)] + last[new Random().nextInt(18)]);
            userDo.setInfo(JSONObject.toJSONString(userDo));
            userMapper.insert(userDo);
        }
        return 0;
    }

    @Override
    public int insertOrUpdate(UserDo userDo) {
        return userMapper.insertOrUpdate(userDo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(UserDo userDo) {
        return userMapper.update(userDo);
    }


    /* 以下方法代码, 可保证多线程的事务性 */
    private static final int threadCount = 4;
    private static Map<String, Boolean> operaResult = new ConcurrentHashMap<>(threadCount);
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String transactionOfMutliThread() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        UserDo userDo = new UserDo();
        userDo.setName("黄龙飞");
        List<UserDo> list = userService.queryList(userDo);
        list.parallelStream().forEach(u -> u.setAge(String.valueOf(Integer.parseInt(u.getAge()) + 1)));

        List<Callable<String>> taskList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            Callable<String> callable = () -> {
                int count = userService.updateForTransactionOfMutliThread(list.subList(finalI * (list.size() / threadCount), (finalI + 1) * (list.size() / threadCount) - 1));
                return "操作的数据索引: " + finalI * (list.size() / threadCount) + "  ~  " + ((finalI + 1) * (list.size() / threadCount) - 1 + ", 完成操作数: " + count);
            };
            taskList.add(callable);
        }

        List<Future<String>> futureList = executor.invokeAll(taskList);
        for (Future<String> future : futureList) {
            try {
                String s = future.get();//此处可以捕获到子线程异常
                System.out.println(s);
            } catch (Exception ex) {
                System.out.println("发生异常, 异常信息: " + ex.getMessage());
                throw new RuntimeException(ex.getMessage());
            } finally {
                operaResult.clear();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("此次操作耗时: " + (endTime - startTime));
        return "ok";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateForTransactionOfMutliThread(List<UserDo> userDoList) {
        int count = 0;
        try {
            for (UserDo userDo : userDoList) {
                count += userMapper.update(userDo);
//                if (userDo.getId().equals("ffe0363e82844d468c6ee870a09e1bcf")) {
//                    int ex = 10 / 0;
//                }
            }
            operaResult.put(Thread.currentThread().getName(), true);
        } catch (Exception ex) {
            System.out.println("发生异常, 异常线程: " + Thread.currentThread().getName() + ", 异常信息为: " + ex.getMessage());
            operaResult.put(Thread.currentThread().getName(), false);
        }

        long startTime = System.currentTimeMillis();
        while (operaResult.size() != threadCount);  //所有线程在此处停顿后, 继续执行
        long endTime = System.currentTimeMillis();
        System.out.println("线程: " + Thread.currentThread().getName() + ", 等待时长: " + (endTime - startTime));

        Collection<Boolean> values = operaResult.values();
        if (values.contains(false)) {
            throw new RuntimeException("有线程异常, 所有线程一并回滚.");
        }

        return count;
    }

    /**
    * @author ywx
    * @date 2020/11/5 16:23
    * @info 内存溢出的场景
    */
    @Override
    public List<UserDo> OutOfMemoryError() {
        return userService.list();
    }

}