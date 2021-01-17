package com.ymj.consumer.loadbalancer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.consumer.loadbalancer
 * @date 2020/9/3 9:03
 * @description
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while(server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            int index = new Random().nextInt(serverCount);
            server = (Server)upList.get(index);
            if (server == null) {
                Thread.yield();
            } else {
                if (server.isAlive()) {
                    return server;
                }

                server = null;
                Thread.yield();
            }
        }

        return server;
    }
}