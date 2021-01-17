package com.ymj.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.eureka.listener
 * @date 2020/8/18 10:54
 * @description 注册中心启动监听器
 */
@Slf4j
@Component
public class EurekaClientDownEventListener {

    @EventListener(condition = "#event.replication == false")
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info("Eureka Server 客户端 {} 下线, 下线时间 = {}", event.getAppName(),
                DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
    }

}