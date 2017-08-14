package com.zuul.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * post: 请求处理完成后执行的filter
 * 这种过滤器在用户请求从Origin Server返回以后执行。
 * 比如在返回的response上面加response header，做各种统计等。
 * 并在该过滤器中把response返回给客户。
 * Created by mao_yejun on 2016/10/23.
 */
public class PostFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PostFilter.class);
    @Override
    public String filterType() {
        return "post";
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
        logger.info("post");
        RequestContext context = RequestContext.getCurrentContext();
        context.getResponse();
//        throw new RuntimeException();
        return null;
    }
}
