package com.msk.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public class QueryNoticeListParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "消息状态")
    private String status;
    @ApiModelProperty(value = "消息类型")
    private String type;
    @ApiModelProperty(value = "消息主题")
    private String title;
    @ApiModelProperty(value = "发件人")
    private String senderCode;
    @ApiModelProperty(value = "收件人")
    private String receiverCode;
    @ApiModelProperty(value = "消息关系ID")
    private String id;
    @ApiModelProperty(value = "消息ID")
    private String messageId;
    @ApiModelProperty(value = "是否需要查询历史数据")
    private Boolean historyFlag;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Boolean getHistoryFlag() {
        return historyFlag;
    }

    public void setHistoryFlag(Boolean historyFlag) {
        this.historyFlag = historyFlag;
    }
}
