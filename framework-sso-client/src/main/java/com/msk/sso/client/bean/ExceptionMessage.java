package com.msk.sso.client.bean;

import java.io.Serializable;

/**
 * ExceptionMessage.
 */
public class ExceptionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private String[] messageParamArray;
    private String fieldName;
    private int rowNum;

    /**
     * The Constructors Method.
     *
     * @param rowNum the row number
     * @param fieldName the field name
     * @param messageCode the message code
     * @param args the message paramters
     */
    public ExceptionMessage(int rowNum, String fieldName, String messageCode, String[] args) {
        this.rowNum = rowNum;
        this.fieldName = fieldName;
        this.message = messageCode;
        this.messageParamArray = args;
    }

    /**
     * The Constructors Method.
     *
     * @param fieldName the field name
     * @param messageCode the message code
     * @param args the message paramters
     */
    public ExceptionMessage(String fieldName, String messageCode, String[] args) {
        this.fieldName = fieldName;
        this.message = messageCode;
        this.messageParamArray = args;
    }

    /**
     * The Constructors Method.
     *
     * @param messageCode the message code
     * @param messageParamArray the message paramters's array
     */
    public ExceptionMessage(String messageCode, String[] messageParamArray) {
        this.message = messageCode;
        this.messageParamArray = messageParamArray;
    }

    /**
     * The Constructors Method.
     */
    public ExceptionMessage() {

    }

    /**
     * The Constructors Method.
     *
     * @param message the message
     */
    public ExceptionMessage(String message) {
        this.message = message;
    }

    /**
     * Get the message
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message
     * 
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the message paramters's array
     * 
     * @return the messageParamArray
     */
    public String[] getMessageParamArray() {
        return messageParamArray;
    }

    /**
     * Set the message paramters's array
     * 
     * @param messageParamArray the messageParamArray to set
     */
    public void setMessageParamArray(String[] messageParamArray) {
        this.messageParamArray = messageParamArray;
    }

    /**
     * Get the field name
     * 
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Set the field name
     * 
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Get the row number
     * 
     * @return the rowNum
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * Set the row number
     * 
     * @param rowNum the rowNum to set
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}
