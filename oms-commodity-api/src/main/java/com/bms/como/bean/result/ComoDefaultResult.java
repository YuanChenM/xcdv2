package com.bms.como.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ComoDefaultResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品主键ID")
    private Long productPid;
    @ApiModelProperty(value = "查询数量")
    private int count;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
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
