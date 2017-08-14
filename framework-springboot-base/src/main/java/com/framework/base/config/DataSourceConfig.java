package com.framework.base.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.framework.base.properties.DataSourceConfigProperties;
import com.framework.datasource.factory.DataSourceFacotry;

/**
 * <p>
 * 加载数据源 Configuration
 * </p>
 * 
 * @author zhangjian3
 * @version 1.0
 * @CreateDate 2016/10/24
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceConfigProperties dataSourceProperties;

    /**
     * <p>
     * 加载beanName=slaveDataSource
     * </p>
     *
     * @return dataSource
     */
    @Bean(name = "slaveDataSource")
    public DataSource slaveDataSource() {

        com.framework.datasource.bean.DataSourceProperties slaveDataSourceProperties = new com.framework.datasource.bean.DataSourceProperties();
        slaveDataSourceProperties.setUrl(dataSourceProperties.getReadOnlyUrl());
        slaveDataSourceProperties.setUserName(dataSourceProperties.getUsername());
        slaveDataSourceProperties.setPassword(dataSourceProperties.getUserpwd());
        slaveDataSourceProperties.setMaxActive(dataSourceProperties.getMaxActive());
        slaveDataSourceProperties.setMaxWait(dataSourceProperties.getMaxWait());
        slaveDataSourceProperties.setMinIdle(dataSourceProperties.getMinIdle());
        slaveDataSourceProperties.setInitialSize(dataSourceProperties.getInitialSize());
        DataSource dataSource = DataSourceFacotry.createDataSource(slaveDataSourceProperties);
        return dataSource;
    }

    /**
     * <p>
     * 加载beanName=dataSource
     * </p>
     *
     * @return dataSource
     */
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        com.framework.datasource.bean.DataSourceProperties masterDataSourceProperties = new com.framework.datasource.bean.DataSourceProperties();
        masterDataSourceProperties.setUrl(dataSourceProperties.getWriteUrl());
        masterDataSourceProperties.setUserName(dataSourceProperties.getUsername());
        masterDataSourceProperties.setPassword(dataSourceProperties.getUserpwd());
        masterDataSourceProperties.setMaxActive(dataSourceProperties.getMaxActive());
        masterDataSourceProperties.setMaxWait(dataSourceProperties.getMaxWait());
        masterDataSourceProperties.setMinIdle(dataSourceProperties.getMinIdle());
        masterDataSourceProperties.setInitialSize(dataSourceProperties.getInitialSize());
        DataSource dataSource = DataSourceFacotry.createDataSource(masterDataSourceProperties);
        return dataSource;
    }
}
