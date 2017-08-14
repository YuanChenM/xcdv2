package com.msk.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dataSource.jdbc")
public class DataSourceConfigProperties{

    private String driverClassName;
    private String username;
    private String userpwd;
    private int initialSize;
    private int maxActive;
    private int minIdle;
    private int maxWait;
    private String writeUrl;
    private String readOnlyUrl;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
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

    public String getWriteUrl() {
        return writeUrl;
    }

    public void setWriteUrl(String writeUrl) {
        this.writeUrl = writeUrl;
    }

    public String getReadOnlyUrl() {
        return readOnlyUrl;
    }

    public void setReadOnlyUrl(String readOnlyUrl) {
        this.readOnlyUrl = readOnlyUrl;
    }
}
