package com.framework.base.bean;

import java.io.Serializable;

/**
 * @deprecated
 *
 * */
public class ConfigParam implements Serializable {
    /** 模块名称 */
    private String modelName;
    /** 环境定义 */
    private String environment;
    /**Type*/
    private String type;
    /**Key*/
    private String key;

    /**
     * 获得modelName
     **/
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置modelName
     *
     * @param modelName modelName
     **/
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获得environment
     **/
    public String getEnvironment() {
        return environment;
    }

    /**
     * 设置environment
     *
     * @param environment environment
     **/
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * 获得type
     **/
    public String getType() {
        return type;
    }

    /**
     * 设置type
     *
     * @param type type
     **/
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获得key
     **/
    public String getKey() {
        return key;
    }

    /**
     * 设置key
     *
     * @param key key
     **/
    public void setKey(String key) {
        this.key = key;
    }
}
