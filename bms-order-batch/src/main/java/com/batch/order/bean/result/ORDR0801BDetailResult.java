package com.batch.order.bean.result;

import com.framework.base.rest.entity.BaseEntity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/2.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "LINE")
@XmlType(propOrder = {"returnDetailId", "sellerId", "sku", "logisticsZoneCode", "goodsUnit", "detailQty", "returnQty",  "returnPrice","inventoryStatus","salesTag"})
public class ORDR0801BDetailResult implements Serializable {
    private Long returnDetailId;

    private String sellerId;

    private String sku;

    private String logisticsZoneCode;

    private String goodsUnit;

    private BigDecimal detailQty;

    private BigDecimal returnQty;

    private BigDecimal returnPrice;

    private String inventoryStatus;

    private String salesTag;

    @XmlElement(name = "RETURNLINE", defaultValue = "")
    public Long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(Long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    @XmlElement(name = "SKUCODE", defaultValue = "")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @XmlElement(name = "UOM", defaultValue = "")
    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    @XmlElement(name = "QTYRETUREN", defaultValue = "")
    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    @XmlElement(name = "INPUTQTY", defaultValue = "")
    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    @XmlElement(name = "QTYORIGINAL", defaultValue = "")
    public BigDecimal getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(BigDecimal detailQty) {
        this.detailQty = detailQty;
    }

    @XmlElement(name = "INVENTORYSTATUS", defaultValue = "")
    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    @XmlElement(name = "CONSIGNEE", defaultValue = "")
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @XmlElement(name = "SALESTAG", defaultValue = "")
    public String getSalesTag() {
        return salesTag;
    }

    public void setSalesTag(String salesTag) {
        this.salesTag = salesTag;
    }

    @XmlElement(name = "AREA", defaultValue = "")
    public String getLogisticsZoneCode() {
        return logisticsZoneCode;
    }

    public void setLogisticsZoneCode(String logisticsZoneCode) {
        this.logisticsZoneCode = logisticsZoneCode;
    }
}
