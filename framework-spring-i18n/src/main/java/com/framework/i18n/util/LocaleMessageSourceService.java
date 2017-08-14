package com.framework.i18n.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * 获取国际化信息工具类
 * Created by shi_yuxi on 2016/10/21.
 */
@Service
public class LocaleMessageSourceService {


    @Autowired
    private MessageSource messageSource;


    /**
     * 获取国际化message
     *
     * @param code 对应messages配置的key.
     * @return 国际化message
     */
    public String getMessage(String code) {

        return this.getMessage(code, new Object[]{});

    }

    /**
     * 获取国际化message
     *
     * @param code           对应messages配置的key.
     * @param defaultMessage 默认message
     * @return 国际化message
     */
    public String getMessage(String code, String defaultMessage) {

        return this.getMessage(code, null, defaultMessage);

    }

    /**
     * 获取国际化message
     *
     * @param code           对应messages配置的key.
     * @param defaultMessage 默认message
     * @param locale         本地语言
     * @return 国际化message
     */
    public String getMessage(String code, String defaultMessage, Locale locale) {

        return this.getMessage(code, null, defaultMessage, locale);

    }

    /**
     * 获取国际化message
     *
     * @param code   对应messages配置的key.
     * @param locale 本地语言
     * @return 国际化message
     */
    public String getMessage(String code, Locale locale) {

        return this.getMessage(code, null, "", locale);

    }


    /**
     * 获取国际化message
     *
     * @param code 对应messages配置的key.
     * @param args 参数
     * @return 国际化message
     */
    public String getMessage(String code, Object[] args) {

        return this.getMessage(code, args, "");

    }

    /**
     * 获取国际化message
     *
     * @param code   对应messages配置的key.
     * @param args   参数
     * @param locale 本地语言
     * @return 国际化message
     */
    public String getMessage(String code, Object[] args, Locale locale) {

        return this.getMessage(code, args, "", locale);

    }


    /**
     * 获取国际化message
     *
     * @param code           对应messages配置的key.
     * @param args           参数
     * @param defaultMessage 默认message
     * @return 国际化message
     */
    public String getMessage(String code, Object[] args, String defaultMessage) {

        //这里使用比较方便的方法，不依赖request.

        Locale locale = LocaleContextHolder.getLocale();

        return this.getMessage(code, args, defaultMessage, locale);

    }


    /**
     * 获取国际化message
     *
     * @param code           对应messages配置的key.
     * @param args           参数
     * @param defaultMessage 默认message
     * @param locale         本地语言
     * @return 国际化message
     */
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {

        return messageSource.getMessage(code, args, defaultMessage, locale);

    }
}