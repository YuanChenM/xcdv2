package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
public class PRCE0206IParam implements Serializable {
    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "通道配置list")
    private List<PRCE0206IWayConfigParam> wayConfigList;

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public List<PRCE0206IWayConfigParam> getWayConfigList() {
        return wayConfigList;
    }

    public void setWayConfigList(List<PRCE0206IWayConfigParam> wayConfigList) {
        this.wayConfigList = wayConfigList;
    }
}
