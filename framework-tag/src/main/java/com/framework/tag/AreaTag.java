package com.framework.tag;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by zhu_kai1 on 2016/12/1.
 */
public class AreaTag extends TagSupport {
    private String areaCode;
    private boolean needAuth = true;
    private static final String authTag = "authTag";
    private static final String excludeKey = "ACTION_ALL";

    public AreaTag() {
        this.init();
    }

    public void release() {
        super.release();
        this.init();
    }

    private void init() {
        this.areaCode = null;
        this.needAuth = false;
    }

    @Override
    public int doStartTag() throws JspException {
//        System.err.println("doStartTag");
        boolean condition = this.condition();
//        System.err.println("condition:" + condition);
        if (condition) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    protected boolean condition() throws JspTagException {
        if (!needAuth) {
            return Boolean.TRUE;
        }
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        Map<String, Object> authMap = (Map) request.getSession().getAttribute(authTag);
        if (authMap.containsKey(areaCode) || authMap.containsKey(excludeKey)) {
            return true;
        }
        return false;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public boolean isNeedAuth() {
        return needAuth;
    }

    public void setNeedAuth(boolean needAuth) {
        this.needAuth = needAuth;
    }
}
