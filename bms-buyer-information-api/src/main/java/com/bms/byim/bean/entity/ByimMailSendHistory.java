/*
 * 2017/02/10 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.byim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表BYIM_MAIL_SEND_HISTORY对应的实体ByimMailSendHistory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ByimMailSendHistory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** MAIL_SEND_HISTORY_ID */
    private Long mailSendHistoryId;
    /** BUYER_ID */
    private String buyerId;
    /** EMAIL_TOPIC */
    private String emailTopic;
    /** EMAIL_CONTENT */
    private String emailContent;
    /** SEND_GROUP */
    private String sendGroup;
    /** 0:不成功  1:成功 */
    private String isSuccess;

    /**
     * <p>默认构造函数</p>
     */
    public ByimMailSendHistory() {
    }

    /**
     * <p>MAIL_SEND_HISTORY_ID</p>
     *
     * @return MAIL_SEND_HISTORY_ID
     */
    public Long getMailSendHistoryId() {
        return mailSendHistoryId;
    }

    /**
     * <p>MAIL_SEND_HISTORY_ID</p>
     *
     * @param mailSendHistoryId MAIL_SEND_HISTORY_ID
     */
    public void setMailSendHistoryId(Long mailSendHistoryId) {
        this.mailSendHistoryId = mailSendHistoryId;
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
     * <p>EMAIL_TOPIC</p>
     *
     * @return EMAIL_TOPIC
     */
    public String getEmailTopic() {
        return emailTopic;
    }

    /**
     * <p>EMAIL_TOPIC</p>
     *
     * @param emailTopic EMAIL_TOPIC
     */
    public void setEmailTopic(String emailTopic) {
        this.emailTopic = emailTopic;
    }
    /**
     * <p>EMAIL_CONTENT</p>
     *
     * @return EMAIL_CONTENT
     */
    public String getEmailContent() {
        return emailContent;
    }

    /**
     * <p>EMAIL_CONTENT</p>
     *
     * @param emailContent EMAIL_CONTENT
     */
    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
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
    /**
     * <p>0:不成功  1:成功</p>
     *
     * @return 0:不成功  1:成功
     */
    public String getIsSuccess() {
        return isSuccess;
    }

    /**
     * <p>0:不成功  1:成功</p>
     *
     * @param isSuccess 0:不成功  1:成功
     */
    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

}
