package com.bms.prce.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sun_jiaju on 2017/01/16.
 */
public class PRCE0206IWayConfigParam implements Serializable {
    @ApiModelProperty(value = "通道配置ID")
    private Long wayConfigId;

    @ApiModelProperty(value = "通道分类ID")
    private Long wayTypeId;

    @ApiModelProperty(value = "通道等级平衡系数")
    private BigDecimal balanceRatio;

    @ApiModelProperty(value = "平台分配系数")
    private BigDecimal platBalanceRatio;

    @ApiModelProperty(value = "买手分配系数")
    private BigDecimal saBalanceRatio;

    @ApiModelProperty(value = "通道准入开始数量")
    private Integer startQty;

    @ApiModelProperty(value = "通道准入结束数量")
    private Integer endQty;

    @ApiModelProperty(value = "删除标志")
    private Boolean delFlg;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public Long getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
    }

    public BigDecimal getBalanceRatio() {
        return balanceRatio;
    }

    public void setBalanceRatio(BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }

    public BigDecimal getSaBalanceRatio() {
        return saBalanceRatio;
    }

    public void setSaBalanceRatio(BigDecimal saBalanceRatio) {
        this.saBalanceRatio = saBalanceRatio;
    }

    public Integer getStartQty() {
        return startQty;
    }

    public void setStartQty(Integer startQty) {
        this.startQty = startQty;
    }

    public Integer getEndQty() {
        return endQty;
    }

    public void setEndQty(Integer endQty) {
        this.endQty = endQty;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getPlatBalanceRatio() {
        return platBalanceRatio;
    }

    public void setPlatBalanceRatio(BigDecimal platBalanceRatio) {
        this.platBalanceRatio = platBalanceRatio;
    }
}
