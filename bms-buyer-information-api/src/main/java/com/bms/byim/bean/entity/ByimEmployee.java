/*
 * 2016/12/29 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_EMPLOYEE对应的实体ByimEmployee</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimEmployee extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** EMPLOYEE_ID */
    private Long employeeId;
    /** BUYER_ID */
    private String buyerId;
    /** STORE_ID */
    private Long storeId;
    /** EMPLOYEE_NAME */
    private String employeeName;
    /** EMPLOYEE_TYPE */
    private String employeeType;
    /** EMPLOYEE_TEL */
    private String employeeTel;
    /** EMPLOYEE_QQ */
    private String employeeQq;
    /** EMPLOYEE_WECHAT */
    private String employeeWechat;
    /** EMPLOYEE_CARD_FLG */
    private Boolean employeeCardFlg;
    /** 存储图片上传文件服务器后返回的ID */
    private String employeeCardPic;
    /** IS_CONTACT_PERSON */
    private Boolean isContactPerson;
    /** IS_PURCHASE */
    private Boolean isPurchase;
    /** IS_RECEIVE_PERSON */
    private Boolean isReceivePerson;
    /** IS_NEWEST_BOSS */
    private Boolean isNewestBoss;

    /**
     * <p>默认构造函数</p>
     */
    public ByimEmployee() {
    }

    /**
     * <p>EMPLOYEE_ID</p>
     *
     * @return EMPLOYEE_ID
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * <p>EMPLOYEE_ID</p>
     *
     * @param employeeId EMPLOYEE_ID
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * <p>BUYER_ID</p>
     *
     * @return BUYER_ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>BUYER_ID</p>
     *
     * @param buyerId BUYER_ID
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
    /**
     * <p>STORE_ID</p>
     *
     * @return STORE_ID
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * <p>STORE_ID</p>
     *
     * @param storeId STORE_ID
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    /**
     * <p>EMPLOYEE_NAME</p>
     *
     * @return EMPLOYEE_NAME
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * <p>EMPLOYEE_NAME</p>
     *
     * @param employeeName EMPLOYEE_NAME
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    /**
     * <p>EMPLOYEE_TYPE</p>
     *
     * @return EMPLOYEE_TYPE
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * <p>EMPLOYEE_TYPE</p>
     *
     * @param employeeType EMPLOYEE_TYPE
     */
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    /**
     * <p>EMPLOYEE_TEL</p>
     *
     * @return EMPLOYEE_TEL
     */
    public String getEmployeeTel() {
        return employeeTel;
    }

    /**
     * <p>EMPLOYEE_TEL</p>
     *
     * @param employeeTel EMPLOYEE_TEL
     */
    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }
    /**
     * <p>EMPLOYEE_QQ</p>
     *
     * @return EMPLOYEE_QQ
     */
    public String getEmployeeQq() {
        return employeeQq;
    }

    /**
     * <p>EMPLOYEE_QQ</p>
     *
     * @param employeeQq EMPLOYEE_QQ
     */
    public void setEmployeeQq(String employeeQq) {
        this.employeeQq = employeeQq;
    }
    /**
     * <p>EMPLOYEE_WECHAT</p>
     *
     * @return EMPLOYEE_WECHAT
     */
    public String getEmployeeWechat() {
        return employeeWechat;
    }

    /**
     * <p>EMPLOYEE_WECHAT</p>
     *
     * @param employeeWechat EMPLOYEE_WECHAT
     */
    public void setEmployeeWechat(String employeeWechat) {
        this.employeeWechat = employeeWechat;
    }
    /**
     * <p>EMPLOYEE_CARD_FLG</p>
     *
     * @return EMPLOYEE_CARD_FLG
     */
    public Boolean getEmployeeCardFlg() {
        return employeeCardFlg;
    }

    /**
     * <p>EMPLOYEE_CARD_FLG</p>
     *
     * @param employeeCardFlg EMPLOYEE_CARD_FLG
     */
    public void setEmployeeCardFlg(Boolean employeeCardFlg) {
        this.employeeCardFlg = employeeCardFlg;
    }
    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @return 存储图片上传文件服务器后返回的ID
     */
    public String getEmployeeCardPic() {
        return employeeCardPic;
    }

    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @param employeeCardPic 存储图片上传文件服务器后返回的ID
     */
    public void setEmployeeCardPic(String employeeCardPic) {
        this.employeeCardPic = employeeCardPic;
    }
    /**
     * <p>IS_CONTACT_PERSON</p>
     *
     * @return IS_CONTACT_PERSON
     */
    public Boolean getIsContactPerson() {
        return isContactPerson;
    }

    /**
     * <p>IS_CONTACT_PERSON</p>
     *
     * @param isContactPerson IS_CONTACT_PERSON
     */
    public void setIsContactPerson(Boolean isContactPerson) {
        this.isContactPerson = isContactPerson;
    }
    /**
     * <p>IS_PURCHASE</p>
     *
     * @return IS_PURCHASE
     */
    public Boolean getIsPurchase() {
        return isPurchase;
    }

    /**
     * <p>IS_PURCHASE</p>
     *
     * @param isPurchase IS_PURCHASE
     */
    public void setIsPurchase(Boolean isPurchase) {
        this.isPurchase = isPurchase;
    }
    /**
     * <p>IS_RECEIVE_PERSON</p>
     *
     * @return IS_RECEIVE_PERSON
     */
    public Boolean getIsReceivePerson() {
        return isReceivePerson;
    }

    /**
     * <p>IS_RECEIVE_PERSON</p>
     *
     * @param isReceivePerson IS_RECEIVE_PERSON
     */
    public void setIsReceivePerson(Boolean isReceivePerson) {
        this.isReceivePerson = isReceivePerson;
    }
    /**
     * <p>IS_NEWEST_BOSS</p>
     *
     * @return IS_NEWEST_BOSS
     */
    public Boolean getIsNewestBoss() {
        return isNewestBoss;
    }

    /**
     * <p>IS_NEWEST_BOSS</p>
     *
     * @param isNewestBoss IS_NEWEST_BOSS
     */
    public void setIsNewestBoss(Boolean isNewestBoss) {
        this.isNewestBoss = isNewestBoss;
    }

}
