package com.bms.prce.bean.result;

import com.bms.prce.bean.entity.PrcePricePlateDetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by sun_jiaju on 2017/01/23.
 */
public class PRCE0209IResult implements Serializable {
    /**
     * 价盘ID
     */
    private Long pricePlateId;
    /**
     * 物流区编码
     */
    private String lgcsAreaCode;
    /**
     * 商品ID
     */
    private String goodId;
    /**
     * 营销通道ID
     */
    private Long marketingWayConfigId;
    /**
     * 营销状态ID
     */
    private Long marketingStatusId;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 买家等级
     */
    private String buyerLevel;
    /**
     * 价盘周期开始时间
     */
    private java.util.Date startTime;
    /**
     * 价盘周期结束时间
     */
    private java.util.Date endTime;
    /**
     * 标准商品定价
     */
    private java.math.BigDecimal normPrice;
    /**
     * 所有人类型
     */
    private String ownerType;
    /**
     * 所有人ID
     */
    private Long ownerId;
    /**
     * 所有人名称
     */
    private String ownerName;

    private String crtId;

    private Date crtTime;

    private String updId;

    private Date updTime;

    private List<PrcePricePlateDetail> plateDetailList;

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

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

    public BigDecimal getNormPrice() {
        return normPrice;
    }

    public void setNormPrice(BigDecimal normPrice) {
        this.normPrice = normPrice;
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

    public List<PrcePricePlateDetail> getPlateDetailList() {
        return plateDetailList;
    }

    public void setPlateDetailList(List<PrcePricePlateDetail> plateDetailList) {
        this.plateDetailList = plateDetailList;
    }

    public String getCrtId() {
        return crtId;
    }

    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
