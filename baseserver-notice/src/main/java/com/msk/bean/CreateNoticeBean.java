package com.msk.bean;


import com.framework.base.rest.entity.BaseEntity;

import java.util.Date;

/**
 * Created by mao_yejun on 2016/10/13.
 */
public class CreateNoticeBean extends BaseEntity{
    private String id;
    private String senderCode;
    private String receiverCode;
    private String status;
    private String type;
    private String messageId;
    private Date sendDateTime;
    private Date lookUpTime;
    private String messageContext;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Date sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public Date getLookUpTime() {
        return lookUpTime;
    }

    public void setLookUpTime(Date lookUpTime) {
        this.lookUpTime = lookUpTime;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
