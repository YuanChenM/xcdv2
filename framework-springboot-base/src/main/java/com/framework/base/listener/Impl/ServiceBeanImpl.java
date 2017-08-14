package com.framework.base.listener.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import com.framework.exception.SystemException;

public class ServiceBeanImpl implements ApplicationContextAware {

    private static Logger log = LoggerFactory.getLogger(ServiceBeanImpl.class);

    private ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void addBeanService(String className) throws SystemException {
        String name = className.substring(className.lastIndexOf(".") + 1);
        if (!context.containsBean(name)) {
            Class<?> serviceClass = getServiceClass(className);
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(serviceClass);
            registerBean(name, beanDefinitionBuilder.getRawBeanDefinition());
        }

    }

    private void registerBean(String beanName, BeanDefinition beanDefinition) {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
        BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
            .getBeanFactory();
        beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
    }

    private Class<?> getServiceClass(String className) throws SystemException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            log.error("not found service class:" + className, e);
            SystemException systemException = new SystemException("not found service class:" + className);
            systemException.initCause(e);
            throw systemException;
        }
    }
}
