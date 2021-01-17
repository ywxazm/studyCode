package com.ymj.boot.mapper;

import com.ymj.boot.pojo.UserDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.mapper
 * @date 2020/10/30 17:06
 * @info
 */
@Repository
public interface UserMapper {

    List<UserDo> list();

    List<UserDo> queryList(UserDo userDo);

    int insert(UserDo userDo);

    int insertOrUpdate(UserDo userDo);

    int update(UserDo userDo);

}