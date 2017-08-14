package com.framework.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.commons.pool2.impl.BaseObjectPoolConfig.DEFAULT_MAX_WAIT_MILLIS;
import static org.apache.commons.pool2.impl.GenericObjectPoolConfig.DEFAULT_MAX_IDLE;
import static org.apache.commons.pool2.impl.GenericObjectPoolConfig.DEFAULT_MAX_TOTAL;

/**
 * Created by mao_yejun on 2016/10/28.
 */
@Component
public class RedisDataSourceProperties {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.pass}")
    private String pass;
    @Value("${redis.dbIndex}")
    private int dbIndex ;
    @Value("${redis.maxIdle}")
    private int maxIdle = DEFAULT_MAX_IDLE;
    @Value("${redis.maxWaitMillis}")
    private long maxWaitMillis = DEFAULT_MAX_WAIT_MILLIS;
    @Value("${redis.maxTotal}")
    private int maxTotal = DEFAULT_MAX_TOTAL;

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
