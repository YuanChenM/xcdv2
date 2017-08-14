package com.framework.mybatis.bean;

import javax.sql.DataSource;

/**
 * @Author zhou_yajun.
 * @Version 1.0
 */
public class MybatisSpringFactoryProperties {

    /** 数据连接*/
    private DataSource dataSource;
    /** mybatis-config.xml路径*/
    private String configPath;
    /** SqlMap-*.xml sql文件路径*/
    private String sqlMapPath;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public String getSqlMapPath() {
        return sqlMapPath;
    }

    public void setSqlMapPath(String sqlMapPath) {
        this.sqlMapPath = sqlMapPath;
    }
}
