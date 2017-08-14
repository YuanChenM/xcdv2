package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
@ApiModel(value = "PRCE0205IResult", description = "营销状态通道Result")
public class PRCE0205IResult implements Serializable {
    @ApiModelProperty(value = "营销通道ID")
    private Long marketingWayConfigId;

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "通道详细list")
    List<PRCE0205IWayConfigResult> wayConfigList;

    public Long getMarketingWayConfigId() {
        return marketingWayConfigId;
    }

    public void setMarketingWayConfigId(Long marketingWayConfigId) {
        this.marketingWayConfigId = marketingWayConfigId;
    }

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
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

    public List<PRCE0205IWayConfigResult> getWayConfigList() {
        return wayConfigList;
    }

    public void setWayConfigList(List<PRCE0205IWayConfigResult> wayConfigList) {
        this.wayConfigList = wayConfigList;
    }
}
