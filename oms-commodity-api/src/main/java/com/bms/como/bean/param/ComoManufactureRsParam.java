package com.bms.como.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public class ComoManufactureRsParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long commodityId;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
}
