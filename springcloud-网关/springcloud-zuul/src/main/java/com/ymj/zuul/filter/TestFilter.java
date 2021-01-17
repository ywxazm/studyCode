package com.ymj.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.zuul.filter
 * @date 2020/9/15 11:20
 * @description
 */
@Component
public class TestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("--------------执行过滤器");
        return null;
    }
}