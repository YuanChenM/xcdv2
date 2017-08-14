package com.framework.datasource.factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.wall.WallFilter;
import com.framework.datasource.bean.DataSourceProperties;
import com.framework.datasource.bean.SimpleDataSourceProperties;
import com.framework.datasource.config.DruidDataSource;

/**
 * @author shi_yuxi
 * @version 1.0
 */
public class DataSourceFacotry {

    /**
     * 通过简单数据获取datadouces
     *
     * @param simpleDataSourceProperties 简单数据参数
     * @return 数据源
     */
    public static DataSource createDataSource(SimpleDataSourceProperties simpleDataSourceProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            DataSourceProperties dataSourceProperties = new DataSourceProperties();
            dataSourceProperties.setUrl(simpleDataSourceProperties.getUrl());
            dataSourceProperties.setUserName(simpleDataSourceProperties.getUserName());
            dataSourceProperties.setPassword(simpleDataSourceProperties.getPassword());
            druidDataSource.configFromDataSourceProperties(dataSourceProperties);
            druidDataSource.setFilters("stat,log4j,slf4j");
            WallFilter wallFilter = new WallFilter();
            wallFilter.setDbType("mysql");
            wallFilter.setLogViolation(true);
            wallFilter.setThrowException(false);
            // WallConfig wallConfig=new WallConfig();
            // wallConfig.setMultiStatementAllow(true);
            // wallFilter.setConfig(wallConfig);
            List<Filter> listFilter = new ArrayList<>();
            listFilter.add(wallFilter);
            druidDataSource.setProxyFilters(listFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    /**
     * 获取datadouces
     *
     * @param dataSourceProperties 完整数据参数
     * @return 数据源
     */
    public static DataSource createDataSource(DataSourceProperties dataSourceProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            druidDataSource.configFromDataSourceProperties(dataSourceProperties);
            druidDataSource.setFilters("stat,log4j,slf4j");
            WallFilter wallFilter = new WallFilter();
            wallFilter.setDbType("mysql");
            wallFilter.setLogViolation(true);
            wallFilter.setThrowException(false);
            // WallConfig wallConfig=new WallConfig();
            // wallConfig.setMultiStatementAllow(true);
            // wallFilter.setConfig(wallConfig);
            List<Filter> listFilter = new ArrayList<>();
            listFilter.add(wallFilter);
            druidDataSource.setProxyFilters(listFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
