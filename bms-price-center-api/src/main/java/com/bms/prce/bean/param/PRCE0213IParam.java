package com.bms.prce.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(value = "PRCE0213IParam",
        description = "价盘信息查询")
public class PRCE0213IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "商品编码")
    private  String commodityCode;

    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;

    @ApiModelProperty(value = "物流区ID")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "是否有价盘")
    private Boolean havePlate;

    @ApiModelProperty(value = "是否有待生效价盘")
    private  Boolean haveLaterPlate;

    @ApiModelProperty(value = "上下架状态")
    private  String shelfStu;

    @ApiModelProperty(value = "所有人类型")
    private String ownerType;

    @ApiModelProperty(value = "所有人ID")
    private Long ownerId;

    @ApiModelProperty(value = "所有人名称")
    private String ownerName;

    @ApiModelProperty(value = "单品名称")
    private String itemName;

    @ApiModelProperty(value = "价盘开始查询时间")
    private String searchStartTime;

    @ApiModelProperty(value = "价盘结束查询时间")
    private String searchEndTime;

    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "品种标准市场销售名")
    private String breedSalesName;

    @ApiModelProperty(value = "品牌")
    private String brandName;

    @ApiModelProperty(value = "规格")
    private String packageSpecification;

    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
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

    public Boolean getHavePlate() {
        return havePlate;
    }

    public void setHavePlate(Boolean havePlate) {
        this.havePlate = havePlate;
    }

    public Boolean getHaveLaterPlate() {
        return haveLaterPlate;
    }

    public void setHaveLaterPlate(Boolean haveLaterPlate) {
        this.haveLaterPlate = haveLaterPlate;
    }

    public String getShelfStu() {
        return shelfStu;
    }

    public void setShelfStu(String shelfStu) {
        this.shelfStu = shelfStu;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSearchStartTime() {
        return searchStartTime;
    }

    public void setSearchStartTime(String searchStartTime) {
        this.searchStartTime = searchStartTime;
    }

    public String getSearchEndTime() {
        return searchEndTime;
    }

    public void setSearchEndTime(String searchEndTime) {
        this.searchEndTime = searchEndTime;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public String getBreedSalesName() {
        return breedSalesName;
    }

    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
}
