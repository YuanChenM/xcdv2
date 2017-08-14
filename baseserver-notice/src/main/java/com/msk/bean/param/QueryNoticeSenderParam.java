package com.msk.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhu_kai1 on 2017/2/22.
 */
public class QueryNoticeSenderParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "消息主题")
    private String title;
    @ApiModelProperty(value = "发件人")
    private String senderCode;
    @ApiModelProperty(value = "消息内容")
    private String messageContext;

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
}
