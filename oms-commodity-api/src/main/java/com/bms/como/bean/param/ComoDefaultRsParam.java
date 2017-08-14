package com.bms.como.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public class ComoDefaultRsParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "产品主键ID")
    private Long productPid;

    public Long getProductPid() {
        return productPid;
    }

    public void setProductPid(Long productPid) {
        this.productPid = productPid;
    }
}
