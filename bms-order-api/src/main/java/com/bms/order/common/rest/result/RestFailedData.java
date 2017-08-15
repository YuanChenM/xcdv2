package com.bms.order.common.rest.result;

import java.io.Serializable;

/**
 * 失败的Data
 * 
 * @author li_huiqian
 *
 */
public class RestFailedData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7528915704589287863L;

    /**
     * 失败数据的ID
     */
    private Object failedDataId;

    /**
     * 失败数据在传入数据中的位置，从0开始
     */
    private int index;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    private String[] errorParams;

    public String[] getErrorParams() {
        return errorParams;
    }

    public void setErrorParams(String[] errorParams) {
        this.errorParams = errorParams;
    }

    /**
     * @return the failedDataId
     */
    public Object getFailedDataId() {
        return failedDataId;
    }

    /**
     * @param failedDataId
     *            the failedDataId to set
     */
    public void setFailedDataId(Object failedDataId) {
        this.failedDataId = failedDataId;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName
     *            the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
