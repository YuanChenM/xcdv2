package com.msk.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by mao_yejun on 2016/10/11.
 */
@Configuration
public class DataSoureConfig {
    @Resource
    private Environment environment;

    @Autowired
    private DataSourceConfigProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getWriteUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getUserpwd());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        ConfigUtils.setEnvironment(environment);
        return dataSource;
    }
}
