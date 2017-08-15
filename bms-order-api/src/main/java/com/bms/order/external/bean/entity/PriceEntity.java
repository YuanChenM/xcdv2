package com.bms.order.external.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/1.
 */
public class PriceEntity {
    //价盘ID
    private Long pricePlateId;
    //商品ID
    private String goodId;
    //物流区编码
    private String lgcsAreaCode;
    //价盘开始时间
    private Date startTime;
    //价盘结束时间
    private Date endTime;
    //通道分类ID
    private Long wayTypeId;
    //通道分类名称
    private String wayTypeName;
    //价格（公斤）
    private BigDecimal price;
    //价格（单位）
    private BigDecimal unitPrice;
    //通道配置ID
    private Long wayConfigId;
    //通道描述
    private String wayDesc;
    //通道等级
    private Long wayLevel;

    private List<PlateDetailEntity> plateDetailList = new ArrayList<>();

    public PriceEntity() {
    }

    public Long getWayConfigId() {
        return wayConfigId;
    }

    public void setWayConfigId(Long wayConfigId) {
        this.wayConfigId = wayConfigId;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }

    public Long getPricePlateId() {
        return pricePlateId;
    }

    public void setPricePlateId(Long pricePlateId) {
        this.pricePlateId = pricePlateId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public Long getWayTypeId() {
        return wayTypeId;
    }

    public void setWayTypeId(Long wayTypeId) {
        this.wayTypeId = wayTypeId;
    }

    public String getWayTypeName() {
        return wayTypeName;
    }

    public void setWayTypeName(String wayTypeName) {
        this.wayTypeName = wayTypeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public List<PlateDetailEntity> getPlateDetailList() {
        return plateDetailList;
    }

    public void setPlateDetailList(List<PlateDetailEntity> plateDetailList) {
        this.plateDetailList = plateDetailList;
    }

    public Long getWayLevel() {
        return wayLevel;
    }

    public void setWayLevel(Long wayLevel) {
        this.wayLevel = wayLevel;
    }
}
