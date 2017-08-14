package com.bms.prce.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "PRCE0213IResult", description = "价盘信息")
public class PRCE0213IResult implements Serializable {

    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;

    @ApiModelProperty(value = "物流区名")
    private String lgcsAreaName;

    @ApiModelProperty(value = "商品ID")
    private String goodId;

    @ApiModelProperty(value = "商品编码")
    private String commodityCode;

    @ApiModelProperty(value = "产品编码")
    private String brandItemPropertySku;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "一级分类名称")
    private String classesName;

    @ApiModelProperty(value = "二级分类名称")
    private String machiningName;

    @ApiModelProperty(value = "品种销售名")
    private String breedSalesName;

    @ApiModelProperty(value = "包装规格")
    private String packageSpecification;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "质量等级编码")
    private String qualityGradeTypeCode;

    @ApiModelProperty(value = "质量等级名称")
    private String qualityGradeTypeName;

    @ApiModelProperty(value = "净重")
    private BigDecimal netWeight;

    @ApiModelProperty(value = "包装数量")
    private Integer packageQuantity;

    @ApiModelProperty(value = "营销状态ID")
    private Long marketingStatusId;

    @ApiModelProperty(value = "营销状态名称")
    private String marketingStatusName;

    @ApiModelProperty(value = "销售状态名称")
    private String saleStatusName;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "用户类型名称")
    private String userTypeName;

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

    private String supPriceofkg;
    private String supPriceofbox;

    private String onePriceofkg;
    private String onepriceofbox;

    private String twoPriceofkg;
    private String twoPriceofbox;

    private String threePriceofkg;
    private String threepriceofbox;

    private String fourPriceofkg;
    private String fourPriceofbox;

    private String fivePriceofkg;
    private String fivepriceofbox;

    private String sixPriceofkg;
    private String sixPriceofbox;

    private String sevenPriceofkg;
    private String sevenpriceofbox;

    private String eightPriceofkg;
    private String eightPriceofbox;

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

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
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

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getQualityGradeTypeCode() {
        return qualityGradeTypeCode;
    }

    public void setQualityGradeTypeCode(String qualityGradeTypeCode) {
        this.qualityGradeTypeCode = qualityGradeTypeCode;
    }

    public String getQualityGradeTypeName() {
        return qualityGradeTypeName;
    }

    public void setQualityGradeTypeName(String qualityGradeTypeName) {
        this.qualityGradeTypeName = qualityGradeTypeName;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
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

    public String getSaleStatusName() {
        return saleStatusName;
    }

    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    public BigDecimal getNormPrice() {
        return normPrice;
    }

    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFuturePriceFlg() {
        return futurePriceFlg;
    }

    public void setFuturePriceFlg(String futurePriceFlg) {
        this.futurePriceFlg = futurePriceFlg;
    }

    public Long getFutureMarketingStatusId() {
        return futureMarketingStatusId;
    }

    public void setFutureMarketingStatusId(Long futureMarketingStatusId) {
        this.futureMarketingStatusId = futureMarketingStatusId;
    }

    public String getBrandItemPropertySku() {
        return brandItemPropertySku;
    }

    public void setBrandItemPropertySku(String brandItemPropertySku) {
        this.brandItemPropertySku = brandItemPropertySku;
    }

    public String getThreepriceofbox() {
        return threepriceofbox;
    }

    public void setThreepriceofbox(String threepriceofbox) {
        this.threepriceofbox = threepriceofbox;
    }

    public String getSupPriceofkg() {
        return supPriceofkg;
    }

    public void setSupPriceofkg(String supPriceofkg) {
        this.supPriceofkg = supPriceofkg;
    }

    public String getSupPriceofbox() {
        return supPriceofbox;
    }

    public void setSupPriceofbox(String supPriceofbox) {
        this.supPriceofbox = supPriceofbox;
    }

    public String getOnePriceofkg() {
        return onePriceofkg;
    }

    public void setOnePriceofkg(String onePriceofkg) {
        this.onePriceofkg = onePriceofkg;
    }

    public String getOnepriceofbox() {
        return onepriceofbox;
    }

    public void setOnepriceofbox(String onepriceofbox) {
        this.onepriceofbox = onepriceofbox;
    }

    public String getTwoPriceofkg() {
        return twoPriceofkg;
    }

    public void setTwoPriceofkg(String twoPriceofkg) {
        this.twoPriceofkg = twoPriceofkg;
    }

    public String getTwoPriceofbox() {
        return twoPriceofbox;
    }

    public void setTwoPriceofbox(String twoPriceofbox) {
        this.twoPriceofbox = twoPriceofbox;
    }

    public String getThreePriceofkg() {
        return threePriceofkg;
    }

    public void setThreePriceofkg(String threePriceofkg) {
        this.threePriceofkg = threePriceofkg;
    }

    public String getFourPriceofkg() {
        return fourPriceofkg;
    }

    public void setFourPriceofkg(String fourPriceofkg) {
        this.fourPriceofkg = fourPriceofkg;
    }

    public String getFourPriceofbox() {
        return fourPriceofbox;
    }

    public void setFourPriceofbox(String fourPriceofbox) {
        this.fourPriceofbox = fourPriceofbox;
    }

    public String getFivePriceofkg() {
        return fivePriceofkg;
    }

    public void setFivePriceofkg(String fivePriceofkg) {
        this.fivePriceofkg = fivePriceofkg;
    }

    public String getFivepriceofbox() {
        return fivepriceofbox;
    }

    public void setFivepriceofbox(String fivepriceofbox) {
        this.fivepriceofbox = fivepriceofbox;
    }

    public String getSixPriceofkg() {
        return sixPriceofkg;
    }

    public void setSixPriceofkg(String sixPriceofkg) {
        this.sixPriceofkg = sixPriceofkg;
    }

    public String getSixPriceofbox() {
        return sixPriceofbox;
    }

    public void setSixPriceofbox(String sixPriceofbox) {
        this.sixPriceofbox = sixPriceofbox;
    }

    public String getSevenPriceofkg() {
        return sevenPriceofkg;
    }

    public void setSevenPriceofkg(String sevenPriceofkg) {
        this.sevenPriceofkg = sevenPriceofkg;
    }

    public String getSevenpriceofbox() {
        return sevenpriceofbox;
    }

    public void setSevenpriceofbox(String sevenpriceofbox) {
        this.sevenpriceofbox = sevenpriceofbox;
    }

    public String getEightPriceofkg() {
        return eightPriceofkg;
    }

    public void setEightPriceofkg(String eightPriceofkg) {
        this.eightPriceofkg = eightPriceofkg;
    }

    public String getEightPriceofbox() {
        return eightPriceofbox;
    }

    public void setEightPriceofbox(String eightPriceofbox) {
        this.eightPriceofbox = eightPriceofbox;
    }

}
