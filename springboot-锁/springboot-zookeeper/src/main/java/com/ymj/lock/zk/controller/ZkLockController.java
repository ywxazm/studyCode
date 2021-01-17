package com.ymj.lock.zk.controller;

import com.ymj.lock.zk.service.ZkService;
import com.ymj.lock.zk.watch.ZkWatch;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk.controller
 * @date 2020/8/17 10:46
 * @description
 */
@RestController
public class ZkLockController {

    @Autowired
    private ZkService zkService;

    @RequestMapping("/lock")
    public String update() throws KeeperException, InterruptedException {
        zkService.lock("/aa", "/bb");

        System.out.println("do lock ...");
        Thread.sleep(15000L);

        zkService.release("/aa", "/bb");

        return "success";
    }
}