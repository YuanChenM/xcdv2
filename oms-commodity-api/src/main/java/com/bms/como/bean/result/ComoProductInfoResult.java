package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ComoProductInfoResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品信息ID")
    private List<Long> productPids;
    @ApiModelProperty(value = "查询数量")
    private int count;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public List<Long> getProductPids() {
        return productPids;
    }

    public void setProductPids(List<Long> productPids) {
        this.productPids = productPids;
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
