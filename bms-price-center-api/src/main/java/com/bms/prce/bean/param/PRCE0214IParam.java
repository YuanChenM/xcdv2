package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/23.
 */
public class PRCE0214IParam implements Serializable {
    @ApiModelProperty(value = "商品ID")
    private String goodId;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
