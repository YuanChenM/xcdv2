package com.framework.base.controller;

import com.framework.base.consts.DateFormatDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * BaseController
 * </p>
 *
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/31
 */
@RequestMapping("api")
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    public BaseController() {
    }

    /**
     * 获得登陆用户信息
     *
     * @return 登陆信息 TODO
     */
    protected void getLoginUser() {
    }

    /**
     * initBinder 实现对日期对象与字符串之间的转换
     *
     * @param binder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat(DateFormatDef.FORMAT_DATE_YYYYMMDD);
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }

    /**
     * 页面forward跳转
     *
     * @param url 目标url
     * @return 页面跳转字符串
     */
    protected String forward(String url) {
        return "forward:" + url;
    }

    /**
     * 页面redirect跳转
     *
     * @param url 目标url
     * @return 页面跳转字符串
     */
    protected String redirect(String url) {
        return "redirect:" + url;
    }
}
