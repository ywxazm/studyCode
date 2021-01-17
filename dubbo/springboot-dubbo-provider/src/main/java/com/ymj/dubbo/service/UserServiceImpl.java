package com.ymj.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ymj.dubbo.api.UserService;
import com.ymj.dubbo.vo.UserVo;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.dubbo.service
 * @date 2020/8/24 9:05
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo() {
        return "name = xiaoming, age = 19";
    }

    @Override
    public UserVo getUserVo() {
        UserVo userVo = new UserVo();
        userVo.setId("1");
        userVo.setName("xiaoming");
        userVo.setAge(19);
        return userVo;
    }

}