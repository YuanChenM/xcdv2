package com.bms.bymt.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhao_chen on 2016/12/14.
 */
@ApiModel(value = "物流区菜场基础信息类", description = "物流区菜场基础信息类")
public class MarketFoodModuleBasicRsParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "菜场主键UUID")
    private String foodMarketId;
    @ApiModelProperty(value = "菜场编码(分类2+物流区2+地区3+区县2+菜场区县顺序码3)")
    private String foodMarketCode;
    @ApiModelProperty(value = "菜场名称")
    private String foodMarketName;
    @ApiModelProperty(value = "菜场地址")
    private String foodMarketAddress;
    @ApiModelProperty(value = "菜场类型")
    private String foodMarketLevel;
    @ApiModelProperty(value = "地段类型")
    private String scopeType;
    @ApiModelProperty(value = "物流区ID")
    private long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "地区ID")
    private long zoneId;
    @ApiModelProperty(value = "地区名称")
    private String zoneCode;
    @ApiModelProperty(value = "地区名称")
    private String zoneName;
    @ApiModelProperty(value = "区县ID")
    private long districtId;
    @ApiModelProperty(value = "区县名称")
    private String districtName;
    @ApiModelProperty(value = "区县编码")
    private String districtCode;
    @ApiModelProperty(value = "占地面积(单位:亩)")
    private Integer coverArea;
    @ApiModelProperty(value = "删除标识")
    private boolean delFlg;
    @ApiModelProperty(value = "菜场类型名称")
    private String foodMarketLevelName;


    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getFoodMarketId() {
        return foodMarketId;
    }

    public void setFoodMarketId(String foodMarketId) {
        this.foodMarketId = foodMarketId;
    }

    public String getFoodMarketCode() {
        return foodMarketCode;
    }

    public void setFoodMarketCode(String foodMarketCode) {
        this.foodMarketCode = foodMarketCode;
    }

    public String getFoodMarketName() {
        return foodMarketName;
    }

    public void setFoodMarketName(String foodMarketName) {
        this.foodMarketName = foodMarketName;
    }

    public String getFoodMarketAddress() {
        return foodMarketAddress;
    }

    public void setFoodMarketAddress(String foodMarketAddress) {
        this.foodMarketAddress = foodMarketAddress;
    }

    public String getFoodMarketLevel() {
        return foodMarketLevel;
    }

    public void setFoodMarketLevel(String foodMarketLevel) {
        this.foodMarketLevel = foodMarketLevel;
    }

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
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

    public long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Integer getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

    public String getFoodMarketLevelName() {
        return foodMarketLevelName;
    }

    public void setFoodMarketLevelName(String foodMarketLevelName) {
        this.foodMarketLevelName = foodMarketLevelName;
    }
}
