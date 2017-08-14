package com.framework.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.framework.aop.boot.dynamic.datasource.DynamicDataSource;

/**
 * <p>
 * 加载事物 Configuration
 * </p>
 * 
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/26
 */
@AutoConfigureAfter(DynamicDataSourceConfig.class)
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfig implements TransactionManagementConfigurer {
    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
