package com.framework.swagger.bean;

/**
 * @author liu_tao2
 * @version 1.0
 */
public class ApiInfoContactProperties {
    /**
     * 名称
     */
    private String name = null;
    /**
     * 地址
     */
    private String url = null;
    /**
     * 邮箱
     */
    private String email = null;

    public ApiInfoContactProperties() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
