package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 价盘一览查询结果
 * @author  zhou_ling
 * @version  1.0
 */
@ApiModel(value = "PRCE0207IResult", description = "价盘一览")
public class PRCE0207IResult implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "商品编码")
    private String commodityCode;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;

    @ApiModelProperty(value = "物流区ID")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区名")
    private String lgcsAreaName;

    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "品种销售名")
    private String breedSalesName;

    @ApiModelProperty(value = "单品名称")
    private String itemName;

    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;

    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "买家等级")
    private String buyerLevel;

    @ApiModelProperty(value = "价盘ID")
    private Long pricePlateId;

    @ApiModelProperty(value = "标准价格")
    private BigDecimal normPrice;

    @ApiModelProperty(value = "标准单位价格")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "价盘开始时间")
    private Date startTime;

    @ApiModelProperty(value = "价盘结束时间")
    private Date endTime;

    @ApiModelProperty(value = "待生效价盘有无")
    private String futurePriceFlg;

    @ApiModelProperty(value = "待生效价盘营销状态ID")
    private Long futureMarketingStatusId;

    @ApiModelProperty(value = "等级名称")
    private String qualityGradeTypeName;
    /**
     * Getter method for property <tt>goodId</tt>.
     *
     * @return property value of goodId
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * Setter method for property <tt>goodId</tt>.
     *
     * @param goodId value to be assigned to property goodId
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * Getter method for property <tt>lgcsAreaCode</tt>.
     *
     * @return property value of lgcsAreaCode
     */
    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * Setter method for property <tt>lgcsAreaCode</tt>.
     *
     * @param lgcsAreaCode value to be assigned to property lgcsAreaCode
     */
    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * Getter method for property <tt>lgcsAreaName</tt>.
     *
     * @return property value of lgcsAreaName
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * Setter method for property <tt>lgcsAreaName</tt>.
     *
     * @param lgcsAreaName value to be assigned to property lgcsAreaName
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * Getter method for property <tt>classesName</tt>.
     *
     * @return property value of classesName
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * Setter method for property <tt>classesName</tt>.
     *
     * @param classesName value to be assigned to property classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * Getter method for property <tt>machiningName</tt>.
     *
     * @return property value of machiningName
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * Setter method for property <tt>machiningName</tt>.
     *
     * @param machiningName value to be assigned to property machiningName
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    /**
     * Getter method for property <tt>breedSalesName</tt>.
     *
     * @return property value of breedSalesName
     */
    public String getBreedSalesName() {
        return breedSalesName;
    }

    /**
     * Setter method for property <tt>breedSalesName</tt>.
     *
     * @param breedSalesName value to be assigned to property breedSalesName
     */
    public void setBreedSalesName(String breedSalesName) {
        this.breedSalesName = breedSalesName;
    }

    /**
     * Getter method for property <tt>netWeight</tt>.
     *
     * @return property value of netWeight
     */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * Setter method for property <tt>netWeight</tt>.
     *
     * @param netWeight value to be assigned to property netWeight
     */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * Getter method for property <tt>brandName</tt>.
     *
     * @return property value of brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Setter method for property <tt>brandName</tt>.
     *
     * @param brandName value to be assigned to property brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Getter method for property <tt>marketingStatusId</tt>.
     *
     * @return property value of marketingStatusId
     */
    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    /**
     * Setter method for property <tt>marketingStatusId</tt>.
     *
     * @param marketingStatusId value to be assigned to property marketingStatusId
     */
    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    /**
     * Getter method for property <tt>marketingStatusName</tt>.
     *
     * @return property value of marketingStatusName
     */
    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    /**
     * Setter method for property <tt>marketingStatusName</tt>.
     *
     * @param marketingStatusName value to be assigned to property marketingStatusName
     */
    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    /**
     * Getter method for property <tt>userType</tt>.
     *
     * @return property value of userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter method for property <tt>userType</tt>.
     *
     * @param userType value to be assigned to property userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Getter method for property <tt>buyerLevel</tt>.
     *
     * @return property value of buyerLevel
     */
    public String getBuyerLevel() {
        return buyerLevel;
    }

    /**
     * Setter method for property <tt>buyerLevel</tt>.
     *
     * @param buyerLevel value to be assigned to property buyerLevel
     */
    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    /**
     * Getter method for property <tt>pricePlateId</tt>.
     *
     * @return property value of pricePlateId
     */
    public Long getPricePlateId() {
        return pricePlateId;
    }

    /**
     * Setter method for property <tt>pricePlateId</tt>.
     *
     * @param pricePlateId value to be assigned to property pricePlateId
     */
    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    /**
     * Getter method for property <tt>normPrice</tt>.
     *
     * @return property value of normPrice
     */
    public BigDecimal getNormPrice() {
        return normPrice;
    }

    /**
     * Setter method for property <tt>normPrice</tt>.
     *
     * @param normPrice value to be assigned to property normPrice
     */
    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
    }

    /**
     * Getter method for property <tt>startTime</tt>.
     *
     * @return property value of startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Setter method for property <tt>startTime</tt>.
     *
     * @param startTime value to be assigned to property startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter method for property <tt>endTime</tt>.
     *
     * @return property value of endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Setter method for property <tt>endTime</tt>.
     *
     * @param endTime value to be assigned to property endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter method for property <tt>futurePriceFlg</tt>.
     *
     * @return property value of futurePriceFlg
     */
    public String getFuturePriceFlg() {
        return futurePriceFlg;
    }

    /**
     * Setter method for property <tt>futurePriceFlg</tt>.
     *
     * @param futurePriceFlg value to be assigned to property futurePriceFlg
     */
    public void setFuturePriceFlg(String futurePriceFlg) {
        this.futurePriceFlg = futurePriceFlg;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public Long getFutureMarketingStatusId() {
        return futureMarketingStatusId;
    }

    public void setFutureMarketingStatusId(Long futureMarketingStatusId) {
        this.futureMarketingStatusId = futureMarketingStatusId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }
}
