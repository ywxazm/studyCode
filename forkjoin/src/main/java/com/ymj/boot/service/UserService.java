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

    List<UserDo> queryList(UserDo userDo);

    void rebase();

    int update(UserDo userDo);

    int batchUpdate(List<UserDo> userDoList);

    int forkJoinBatchUpdate(List<UserDo> userDoList);

}