package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ComoInfoResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品信息ID")
    private Long commodityId;
    @ApiModelProperty(value = "查询数量")
    private int count;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
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
