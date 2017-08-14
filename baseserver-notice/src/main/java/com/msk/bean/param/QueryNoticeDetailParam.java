package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public class QueryNoticeDetailParam implements Serializable{
    @ApiModelProperty(value = "消息关系id")
    private String id;
    @ApiModelProperty(value = "消息id")
    private String messageId;
    @ApiModelProperty(value = "消息主题")
    private String title;
    @ApiModelProperty(value = "发件人")
    private String senderCode;
    @ApiModelProperty(value = "收件人")
    private String receiverCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
