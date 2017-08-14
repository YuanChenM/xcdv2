package com.framework.comm;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.jsp.PageContext;

/**
 * Created by zhu_kai1 on 2016/11/28.
 */
public abstract class ApplicationBaseTag extends BaseTag {

    protected <T> Object getApplicationBean(String name, Class<T> Class) {
        PageContext pageContext = (PageContext)this.getJspContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
        Object taglogic = ctx.getBean(name, Class);
        return taglogic;
    }
}
