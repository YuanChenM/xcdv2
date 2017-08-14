package com.zuul.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * Created by mao_yejun on 2016/12/19.
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperties.getWriteUrl());
        druidDataSource.setPassword(dataSourceProperties.getUserpwd());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setInitialSize(dataSourceProperties.getInitialSize());
        druidDataSource.setMaxActive(dataSourceProperties.getMaxActive());
        druidDataSource.setMinIdle(dataSourceProperties.getMinIdle());
        druidDataSource.setMaxWait(dataSourceProperties.getMaxWait());
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setDbType("mysql");
        druidDataSource.setPoolPreparedStatements(false);
        return druidDataSource;

    }
}
