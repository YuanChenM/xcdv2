package com.zuul.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * route: 处理请求，进行路由
 * 在这种过滤器中把用户请求发送给Origin Server。
 * 发送给Origin Server的用户请求在这类过滤器中build。
 * 并使用Apache HttpClient或者Netfilx Ribbon发送给Origin Server
 * Created by mao_yejun on 2016/10/23.
 */
public class RoutingFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(RoutingFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        logger.info("routing");
        RequestContext context = RequestContext.getCurrentContext();
        return null;
    }
}
