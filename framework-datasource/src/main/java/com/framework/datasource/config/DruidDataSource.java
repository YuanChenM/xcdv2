package com.framework.datasource.config;

import com.framework.datasource.bean.DataSourceProperties;

/**
 * @author shi_yuxi
 * @version 1.0
 */
public class DruidDataSource extends com.alibaba.druid.pool.DruidDataSource{
    /**
     * datasource初始化参数,给datasource赋值
     *
     * @param dataSourceProperties datasource初始化参数
     */
    public void configFromDataSourceProperties(DataSourceProperties dataSourceProperties) {
        this.setUrl(dataSourceProperties.getUrl());
        this.setUsername(dataSourceProperties.getUserName());//用户名
        this.setPassword(dataSourceProperties.getPassword());//密码
        this.setInitialSize(dataSourceProperties.getInitialSize());
        this.setMaxActive(dataSourceProperties.getMaxActive());
        this.setMinIdle(dataSourceProperties.getMinIdle());
        this.setMaxWait(dataSourceProperties.getMaxWait());
        this.setValidationQuery(dataSourceProperties.getValidationQuery());
        this.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        this.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
        this.setPoolPreparedStatements(dataSourceProperties.isPoolPreparedStatements());
        this.setDriverClassName(dataSourceProperties.getDriverClassName());
    }
}
