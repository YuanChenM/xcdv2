package com.framework.base.listener.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.core.env.ConfigurableEnvironment;

import com.framework.base.listener.IApplicationEvent;
import com.framework.base.properties.ConfigServerPropertyLoad;
import com.framework.core.utils.StringUtils;
import com.framework.exception.SystemException;

public class ApplicationPreparedEventImpl implements IApplicationEvent<ApplicationPreparedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ApplicationPreparedEventImpl.class);

    public void init(ApplicationPreparedEvent applicationEvent) {
        try {
            ConfigurableEnvironment environment = applicationEvent.getApplicationContext().getEnvironment();
            ConfigServerPropertyLoad.setEnvironment(environment);
            ServiceBeanImpl sbi = new ServiceBeanImpl();
            sbi.setApplicationContext(applicationEvent.getApplicationContext());
            if (ConfigServerPropertyLoad.getIfSwagger()) {
                sbi.addBeanService("com.framework.base.config.SwaggerConfig");
            }
            if (ConfigServerPropertyLoad.getIfDataSource()) {
                sbi.addBeanService(!StringUtils.isEmpty(ConfigServerPropertyLoad.getIfDataSourceClassName())
                    ? ConfigServerPropertyLoad.getIfDataSourceClassName()
                    : "com.framework.base.config.DataSourceConfig");
                sbi.addBeanService("com.framework.base.config.DynamicDataSourceConfig");
                sbi.addBeanService("com.framework.base.config.TransactionManagementConfig");
                sbi.addBeanService("com.framework.base.config.MybatisSpringConfig");
                sbi.addBeanService("com.framework.base.config.MybatisDaoConfig");
            }

        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
}
