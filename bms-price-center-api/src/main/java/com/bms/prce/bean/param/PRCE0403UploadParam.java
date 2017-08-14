package com.bms.prce.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by memorykai on 2017/5/7.
 */
public class PRCE0403UploadParam implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * excel参数
     */
    //区域
    private String lgcsAreaName;
    private String lgcsAreaCode;
    //商品编码
    private String commodityCode;
    private String goodId;
    //产品编码
    private String productCode;
    //营销状态
    private String marketingStatusName;
    private Long marketingStatusId;
    //价盘用户类型
    private String userTypeName;
    private String userType;
    //买家等级
    private String buyerLevelName;
    private String buyerLevel;
    //生效时间
    private String startTime;
    //基准申报价格(元/kg)
    private BigDecimal normPrice;
    //通道配置数据
    private List<PRCE0403UploadDetailParam> pricePlateList;

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMarketingStatusName() {
        return marketingStatusName;
    }

    public void setMarketingStatusName(String marketingStatusName) {
        this.marketingStatusName = marketingStatusName;
    }

    public Long getMarketingStatusId() {
        return marketingStatusId;
    }

    public void setMarketingStatusId(Long marketingStatusId) {
        this.marketingStatusId = marketingStatusId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBuyerLevelName() {
        return buyerLevelName;
    }

    public void setBuyerLevelName(String buyerLevelName) {
        this.buyerLevelName = buyerLevelName;
    }

    public String getBuyerLevel() {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel) {
        this.buyerLevel = buyerLevel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getNormPrice() {
        return normPrice;
    }

    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
    }

    public List<PRCE0403UploadDetailParam> getPricePlateList() {
        return pricePlateList;
    }

    public void setPricePlateList(List<PRCE0403UploadDetailParam> pricePlateList) {
        this.pricePlateList = pricePlateList;
    }
}
