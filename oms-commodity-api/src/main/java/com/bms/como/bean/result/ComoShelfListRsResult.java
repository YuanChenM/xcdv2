package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ComoShelfListRsResult implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "上下架明细ID")
//    private List<Long> shelfDetailId;
    @ApiModelProperty(value = "成功数量")
    private int successCount;
    @ApiModelProperty(value = "商品ID")
    private List<Long> failShelfDetailId;
//    @ApiModelProperty(value = "失败数量")
//    private int failCount;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public List<Long> getFailShelfDetailId() {
        return failShelfDetailId;
    }

    public void setFailShelfDetailId(List<Long> failShelfDetailId) {
        this.failShelfDetailId = failShelfDetailId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
