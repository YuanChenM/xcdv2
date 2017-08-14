package com.framework.base.rest;

import java.io.Serializable;

/**
 * 服务接口返回值
 *
 * @param <T> 返回值类型
 * @author mao_yejun
 * @version 1.0
 */
@Deprecated
public class RestResponse<T> implements Serializable {
    /**
     * 返回消息
     */
    private String[] message;
    /**
     * 业务返回值
     */
    private T result;

    /**
     * 构造方法
     */
    public RestResponse() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
