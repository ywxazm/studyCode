package com.ymj.lock.zk.watch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Component;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lock.zk.watch
 * @date 2020/8/17 11:18
 * @description
 */
@Component
public class ZkWatch implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("do watch ... ");
    }
}