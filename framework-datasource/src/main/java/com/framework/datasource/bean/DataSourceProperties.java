package com.framework.datasource.bean;

/**
 * datasources初始化数据
 * Created by shi_yuxi on 2016/10/21.
 */
public class DataSourceProperties extends SimpleDataSourceProperties{
    /**
     * 连接池启动时创建的初始化连接数量（默认值为1）
     */
    private int initialSize = 1;
    /**
     * 连接池中可同时连接的最大的连接数（默认值为1，自己根据应用场景定）
     */
    private int maxActive = 1;
    /**
     * 连接池中最小的空闲的连接数，低于这个数量会被创建新的连接（默认为1，该参数越接近maxIdle，性能越好，因为连接的创建和销毁，都是需要消耗资源的；但是不能太大，因为在机器很空闲的时候，也会创建低于minidle个数的连接，类似于jvm参数中的Xmn设置）
     */
    private int minIdle = 1;
    /**
     * 最大等待时间，当没有可用连接时，连接池等待连接释放的最大时间，超过该时间限制会抛出异常，如果设置-1表示无限等待（默认为6000ms，避免因线程池不够用，而导致请求被无限制挂起）
     */
    private int maxWait = 6000;

    /**
     * 校验的查询语句
     */
    private String validationQuery = "SELECT 1";
    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean testOnBorrow = false;
    /**
     * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean testWhileIdle = true;
    /**
     * 开启池的prepared（默认是false，经过测试，开启后的性能没有关闭的好。）
     */
    private boolean poolPreparedStatements = false;
    private String driverClassName = "com.mysql.jdbc.Driver";

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }
}
