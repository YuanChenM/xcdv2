package com.bms.byim.bean.entity;

import java.io.Serializable;

/**
 * Created by tao_zhifa on 2017/2/15.
 */
public class RsResponse<T> implements Serializable {
    /**
     * 状态
     */
    private String status;
    /**
     * 返回代码
     */
    private String returnCode;
    /**
     * 结果消息
     */
    private String message;
    /**
     * 业务返回值
     */
    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}