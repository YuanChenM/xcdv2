package com.framework.number.generate.database.redis.properties;

import java.io.Serializable;

/**
 * 连接Redis参数
 * @author jiang_nan
 * @version 1.0
 */
public class RedisParam implements Serializable{
    /**IP 地址*/
    private String host;
    /**端口*/
    private int port;
    /**密码*/
    private String password;
    /**连接的DB*/
    private int database;
    /**超时时间*/
    private int timeout;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
