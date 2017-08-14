package com.zuul.fliter;

import com.netflix.zuul.ExecutionStatus;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zuul.config.ApiKeyConfig;
import com.zuul.logic.ApiAuthLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.security.AuthenticationAuditListener;

import javax.servlet.http.HttpServletRequest;

/**
 * pre:请求执行之前filter
 * 这种过滤器在请求到达Origin Server之前调用。
 * 比如身份验证，在集群中选择请求的Origin Server，记log等
 * Created by mao_yejun on 2016/10/23.
 */
public class PreFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PreFilter.class);
    @Autowired
    private ApiAuthLogic apiAuthLogic;
    @Autowired
    private ApiKeyConfig apiKeyConfig;

    @Override
    public String filterType() {
        return "pre";
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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        boolean doAuthFlg = apiKeyConfig.getDoAuthFlg();
        if (doAuthFlg) {
            boolean auth = apiAuthLogic.doAuth(request);
            if (!auth) {
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                return null;
            }
        }
        return null;
    }
}
