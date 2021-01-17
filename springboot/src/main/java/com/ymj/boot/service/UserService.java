package com.ymj.boot.service;

import com.ymj.boot.pojo.UserDo;

import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.service
 * @date 2020/10/30 17:06
 * @description
 */
public interface UserService {

    List<UserDo> list();

    List<UserDo> queryList(UserDo userDo);

    void rebase();

    int insert(UserDo userDo);

    int insertList();

    int insertOrUpdate(UserDo userDo);

    int update(UserDo userDo);

    String transactionOfMutliThread() throws InterruptedException;

    int updateForTransactionOfMutliThread(List<UserDo> userDoList);

    List<UserDo> OutOfMemoryError();

}