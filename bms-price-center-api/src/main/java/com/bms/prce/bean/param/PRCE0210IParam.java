package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by sun_jiaju on 2017/01/17.
 */
public class PRCE0210IParam implements Serializable {
    @ApiModelProperty(value = "营销通道ID")
    private Long[] marketingWayConfigIds;

    public Long[] getMarketingWayConfigIds() {
        return marketingWayConfigIds;
    }

    public void setMarketingWayConfigIds(Long[] marketingWayConfigIds) {
        this.marketingWayConfigIds = marketingWayConfigIds;
    }
}
