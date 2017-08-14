package com.bms.byim.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by yuan_zhifei on 2017/2/9.
 */
@ApiModel(value = "StoreRsParam", description = "买家店铺信息查询参数")
public class StoreRsParam implements Serializable {
    @ApiModelProperty(value = "店铺ID")
    private Long storeId;
    @ApiModelProperty(value = "买家ID")
    private String buyerId;
    @ApiModelProperty(value = "市场ID")
    private String marketId;
    @ApiModelProperty(value = "市场名称")
    private String marketName;
    @ApiModelProperty(value = "市场编码")
    private String marketCode;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "地区编码")
    private String cityCode;
    @ApiModelProperty(value = "地区名称")
    private String cityName;
    @ApiModelProperty(value = "市场级别名称")
    private String marketLevelName;
    @ApiModelProperty(value = " 0:表示菜场;1:表示批发市场")
    private String marketType;
    @ApiModelProperty(value = "市场级别")
    private String marketLevel;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMarketLevelName() {
        return marketLevelName;
    }

    public void setMarketLevelName(String marketLevelName) {
        this.marketLevelName = marketLevelName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getMarketLevel() {
        return marketLevel;
    }

    public void setMarketLevel(String marketLevel) {
        this.marketLevel = marketLevel;
    }
}
