package com.framework.datasource.bean;

/**
 * datasources初始化数据
 * Created by shi_yuxi on 2016/10/21.
 */
public class SimpleDataSourceProperties{
    /**
     * db的url
     */
    private String url;
    /**
     * db用户名
     */
    private String userName;
    /**
     * db密码
     */
    private String password;

    public SimpleDataSourceProperties(String url, String userName, String password){
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
    public SimpleDataSourceProperties(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
