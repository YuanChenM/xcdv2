package com.framework.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by zhu_kai1 on 2016/11/28.
 */
public abstract class BaseTag extends SimpleTagSupport {
    protected abstract void doTag(HttpServletRequest var1) throws JspException, IOException;

    public void doTag() throws JspException, IOException {
        this.doTag(this.getRequest());
    }

    protected HttpServletRequest getRequest() {
        PageContext pageContext = (PageContext)this.getJspContext();
        return (HttpServletRequest)pageContext.getRequest();
    }


}
