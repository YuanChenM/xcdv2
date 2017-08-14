package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ComoShelfListRecordRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品信息ID")
    private Long recordId;
    @ApiModelProperty(value = "数量")
    private int count;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
