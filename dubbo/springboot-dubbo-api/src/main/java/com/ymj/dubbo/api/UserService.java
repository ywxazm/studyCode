package com.ymj.dubbo.api;

import com.ymj.dubbo.vo.UserVo;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.dubbo.api
 * @date 2020/8/24 8:57
 * @description
 */
public interface UserService {

    String getUserInfo();

    UserVo getUserVo();

}