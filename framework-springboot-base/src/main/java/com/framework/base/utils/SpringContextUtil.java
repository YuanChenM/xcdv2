package com.framework.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil{
    /**
     * logger
     */
    // private static Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);
    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // logger.debug("applicationContext");
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取对象
     * 这里重写了bean方法，起主要作用
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 获得Spring 容器中的Java Bean
     *
     * @param name JavaBean Name
     * @param clazz Clazz
     * @param <T> JavaBean
     * @return JavaBean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}