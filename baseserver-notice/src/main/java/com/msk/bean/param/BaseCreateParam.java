package com.msk.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * Created by mao_yejun on 2016/10/12.
 */
public class BaseCreateParam implements Serializable {
    @ApiModelProperty(value = "发送者")
    private String senderCode;
    @ApiModelProperty(value = "消息内容")
    private String messageContext;
    @ApiModelProperty(value = "消息类型.0 为系统消息")
    private String type;
    @ApiModelProperty(value = "消息主题")
    private String title;

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

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
