package com.ymj.mongodb.dao;

import com.ymj.mongodb.docment.UserDocument;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.mongodb.dao
 * @date 2020/8/14 14:34
 * @description
 */
public interface UserDao {

    void save(UserDocument userDocument);

    void delete(String id);

    void update(UserDocument userDocument);

    UserDocument query(String id);

    void transaction();
}