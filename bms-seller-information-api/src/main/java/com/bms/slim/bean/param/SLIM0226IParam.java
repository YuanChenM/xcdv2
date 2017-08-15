package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "SLIM0226IParam", description = "查询生产商工厂接口入参")
public class SLIM0226IParam extends BaseRestPaginationParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商工厂ID集合")
    private List<Long> factoryIds;
    @ApiModelProperty(value = "卖家角色ID集合")
    private List<Long> sellerRoleIds;
    @ApiModelProperty(value = "总资产")
    private java.math.BigDecimal totalAsset;
    @ApiModelProperty(value = "注册资本")
    private java.math.BigDecimal registeredCapital;
    @ApiModelProperty(value = "占地面积")
    private java.math.BigDecimal coveredArea;
    @ApiModelProperty(value = "厂房面积")
    private java.math.BigDecimal workshopArea;
    @ApiModelProperty(value = "主要设备")
    private String majorEquipment;
    @ApiModelProperty(value = "设计产能")
    private String designCapacity;
    @ApiModelProperty(value = "外贸销售占比")
    private String exportSalePercent;
    @ApiModelProperty(value = "自销占比")
    private String selfSalePercent;
    @ApiModelProperty(value = "代理销售占比")
    private String agentSalePercent;
    @ApiModelProperty(value = "厂区照(远景)URL")
    private String factoryPicUrl;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getFactoryIds() {
        return factoryIds;
    }

    public void setFactoryIds(List<Long> factoryIds) {
        this.factoryIds = factoryIds;
    }

    public List<Long> getSellerRoleIds() {
        return sellerRoleIds;
    }

    public void setSellerRoleIds(List<Long> sellerRoleIds) {
        this.sellerRoleIds = sellerRoleIds;
    }

    public BigDecimal getTotalAsset() {
        return totalAsset;
    }

    public void setTotalAsset(BigDecimal totalAsset) {
        this.totalAsset = totalAsset;
    }

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public BigDecimal getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(BigDecimal coveredArea) {
        this.coveredArea = coveredArea;
    }

    public BigDecimal getWorkshopArea() {
        return workshopArea;
    }

    public void setWorkshopArea(BigDecimal workshopArea) {
        this.workshopArea = workshopArea;
    }

    public String getMajorEquipment() {
        return majorEquipment;
    }

    public void setMajorEquipment(String majorEquipment) {
        this.majorEquipment = majorEquipment;
    }

    public String getDesignCapacity() {
        return designCapacity;
    }

    public void setDesignCapacity(String designCapacity) {
        this.designCapacity = designCapacity;
    }

    public String getExportSalePercent() {
        return exportSalePercent;
    }

    public void setExportSalePercent(String exportSalePercent) {
        this.exportSalePercent = exportSalePercent;
    }

    public String getSelfSalePercent() {
        return selfSalePercent;
    }

    public void setSelfSalePercent(String selfSalePercent) {
        this.selfSalePercent = selfSalePercent;
    }

    public String getAgentSalePercent() {
        return agentSalePercent;
    }

    public void setAgentSalePercent(String agentSalePercent) {
        this.agentSalePercent = agentSalePercent;
    }

    public String getFactoryPicUrl() {
        return factoryPicUrl;
    }

    public void setFactoryPicUrl(String factoryPicUrl) {
        this.factoryPicUrl = factoryPicUrl;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}
