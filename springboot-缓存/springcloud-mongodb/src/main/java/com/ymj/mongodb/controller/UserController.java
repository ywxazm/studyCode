package com.ymj.mongodb.controller;

import com.ymj.mongodb.dao.UserDao;
import com.ymj.mongodb.docment.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.mongodb.controller
 * @date 2020/8/14 14:42
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/save")
    public void save(UserDocument userDocument) {userDao.save(userDocument);}

    @RequestMapping("/delete")
    public void delete(String id){userDao.delete(id);}

    @RequestMapping("/update")
    public void update(UserDocument userDocument){userDao.update(userDocument);}

    @RequestMapping("/query")
    public UserDocument query(String id){ return userDao.query(id);}

    @RequestMapping("/transaction")
    public UserDocument transaction(String id){ return userDao.query(id);}


}