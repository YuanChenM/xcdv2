package com.framework.base.config;

import com.framework.aop.boot.dynamic.datasource.DatabaseContextHolder;
import com.framework.aop.boot.dynamic.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 加载动态数据源 Configuration
 * </p>
 * @Author zhou_yajun.
 * @Version 1.0
 */
@AutoConfigureAfter(DataSourceConfig.class)
@Configuration
public class DynamicDataSourceConfig {
    @Autowired
    private DataSourceConfig dataSourceConfig;
    @Bean(name = "dataSource")
    public DynamicDataSource dynamicDataSource(){

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseContextHolder.MASTER_DATA_SOURCE,dataSourceConfig.masterDataSource());
        targetDataSources.put(DatabaseContextHolder.SLAVE_DATA_SOURCE,dataSourceConfig.slaveDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceConfig.masterDataSource());
        return dynamicDataSource;
    }
}
