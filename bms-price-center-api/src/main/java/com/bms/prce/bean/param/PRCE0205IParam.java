package com.bms.prce.bean.param;

import com.framework.base.bean.Sort;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
public class PRCE0205IParam implements Serializable {
    @ApiModelProperty(value = "营销状态ID")
    private Long[] marketingStatusId;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "查询有效通道配置flag")
    private Boolean effectiveFlg;

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

    public Boolean getEffectiveFlg() {
        return effectiveFlg;
    }

    public void setEffectiveFlg(Boolean effectiveFlg) {
        this.effectiveFlg = effectiveFlg;
    }

    public Long[] getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long[] marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }
}
