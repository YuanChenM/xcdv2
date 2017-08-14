package com.zuul.fliter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ERROR：在其他阶段发生错误时执行该过滤器
 * Created by mao_yejun on 2016/10/23.
 */
public class ErrorFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
    @Override
    public String filterType() {
        return "error";
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
        logger.info("error");
        return null;
    }
}
