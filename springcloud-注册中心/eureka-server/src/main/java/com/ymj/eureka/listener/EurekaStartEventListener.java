package com.ymj.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.eureka.listener
 * @date 2020/8/18 10:54
 * @description 注册中心启动监听器
 */
@Slf4j
@Component
public class EurekaStartEventListener {

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("Eureka Server Tomcat 启动, 启动时间 = {}",
                DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
    }

}