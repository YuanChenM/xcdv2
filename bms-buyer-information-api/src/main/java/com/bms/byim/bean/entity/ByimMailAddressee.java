/*
 * 2017/02/10 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_MAIL_ADDRESSEE对应的实体ByimMailAddressee</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimMailAddressee extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** MAIL_ADDRESSEE_ID */
    private Long mailAddresseeId;
    /** ADDRESSEE_NAME */
    private String addresseeName;
    /** ADDRESSEE_EMAIL */
    private String addresseeEmail;
    /** 0:发送  1:抄送 */
    private String sendType;
    /** SEND_GROUP */
    private String sendGroup;

    /**
     * <p>默认构造函数</p>
     */
    public ByimMailAddressee() {
    }

    /**
     * <p>MAIL_ADDRESSEE_ID</p>
     *
     * @return MAIL_ADDRESSEE_ID
     */
    public Long getMailAddresseeId() {
        return mailAddresseeId;
    }

    /**
     * <p>MAIL_ADDRESSEE_ID</p>
     *
     * @param mailAddresseeId MAIL_ADDRESSEE_ID
     */
    public void setMailAddresseeId(Long mailAddresseeId) {
        this.mailAddresseeId = mailAddresseeId;
    }
    /**
     * <p>ADDRESSEE_NAME</p>
     *
     * @return ADDRESSEE_NAME
     */
    public String getAddresseeName() {
        return addresseeName;
    }

    /**
     * <p>ADDRESSEE_NAME</p>
     *
     * @param addresseeName ADDRESSEE_NAME
     */
    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }
    /**
     * <p>ADDRESSEE_EMAIL</p>
     *
     * @return ADDRESSEE_EMAIL
     */
    public String getAddresseeEmail() {
        return addresseeEmail;
    }

    /**
     * <p>ADDRESSEE_EMAIL</p>
     *
     * @param addresseeEmail ADDRESSEE_EMAIL
     */
    public void setAddresseeEmail(String addresseeEmail) {
        this.addresseeEmail = addresseeEmail;
    }
    /**
     * <p>0:发送  1:抄送</p>
     *
     * @return 0:发送  1:抄送
     */
    public String getSendType() {
        return sendType;
    }

    /**
     * <p>0:发送  1:抄送</p>
     *
     * @param sendType 0:发送  1:抄送
     */
    public void setSendType(String sendType) {
        this.sendType = sendType;
    }
    /**
     * <p>SEND_GROUP</p>
     *
     * @return SEND_GROUP
     */
    public String getSendGroup() {
        return sendGroup;
    }

    /**
     * <p>SEND_GROUP</p>
     *
     * @param sendGroup SEND_GROUP
     */
    public void setSendGroup(String sendGroup) {
        this.sendGroup = sendGroup;
    }

}
