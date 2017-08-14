package com.msk.comm.bean;

import java.io.Serializable;


public class ConfigParam implements Serializable {
    /** 模块名称 */
    private String modelName;
    /** 环境定义 */
    private String environment;
    /**Type*/
    private String type;
    /**Key*/
    private String key;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
