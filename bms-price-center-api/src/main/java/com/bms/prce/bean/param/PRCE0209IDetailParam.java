package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/23.
 */
public class PRCE0209IDetailParam implements Serializable {
    @ApiModelProperty(value = "通道配置ID")
    private Long wayConfigId;

    @ApiModelProperty(value = "实际价格")
    private BigDecimal factPrice;

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public BigDecimal getFactPrice() {
        return factPrice;
    }

    public void setFactPrice(BigDecimal factPrice) {
        this.factPrice = factPrice;
    }
}
