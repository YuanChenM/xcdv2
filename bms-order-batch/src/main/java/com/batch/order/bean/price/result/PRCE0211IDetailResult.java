package com.batch.order.bean.price.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/8.
 */
public class PRCE0211IDetailResult implements Serializable {

    private static final long serialVersionUID = 4966684673548754807L;

    //商品ID
    private String goodId;
    //通道开始数量
    private BigDecimal startQty;
    //通道结束数量
    private BigDecimal endQty;
    //价格（公斤）
    private BigDecimal price;
    //价格（单位）
    private BigDecimal unitPrice;
    //通道分类ID
    private Long wayTypeId;
    //通道分类名称
    private String wayTypeName;
    //通道配置ID
    private Long wayConfigId;
    //通道描述
    private String wayDesc;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public BigDecimal getStartQty() {
        return startQty;
    }

    public void setStartQty(BigDecimal startQty) {
        this.startQty = startQty;
    }

    public BigDecimal getEndQty() {
        return endQty;
    }

    public void setEndQty(BigDecimal endQty) {
        this.endQty = endQty;
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
}
