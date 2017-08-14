package com.msk.comm.bean;

import java.io.Serializable;

/**
 * Web Service 服务接口返回值
 * 
 * @param <T> 返回值类型
 */
// @JsonInclude(Include.NON_NULL)
public class RestResponse<T> implements Serializable{
    /** 状态 */
    private String status;
    /** 返回代码 */
    private String returnCode;
    /** 结果消息 */
    private String message;
    /** 业务返回值 */
    private T result;

    /**
     * 构造方法
     */
    public RestResponse() {

    }

    /**
     * Get the status.
     *
     * @return status
     *
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Set the status.
     *
     * @param status status
     *
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * Get the message.
     *
     * @return message
     *
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message.
     *
     * @param message message
     *
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the result.
     *
     * @return result
     *
     */
    public T getResult() {
        return this.result;
    }

    /**
     * Set the result.
     *
     * @param result result
     *
     */
    public void setResult(T result) {
        this.result = result;
    }

}
