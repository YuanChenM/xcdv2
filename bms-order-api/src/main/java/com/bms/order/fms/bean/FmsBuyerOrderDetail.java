package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/12 0012.
 *
 * Fms买家订单明细（产品信息）
 */
public class FmsBuyerOrderDetail implements Serializable {
    private static final long serialVersionUID = 3745803245492535203L;

    //行编号
    private Long lineNum;
    //商品ID对应的产品ID
    private String productId;
    //数量
    private BigDecimal orderedQuantity;
    //单位
    private String orderQuantityUom;
    //单价
    private BigDecimal unitSellingPriceDsp;
    //sku
    private String itemSku;
    //生产商code
    private String producerCode;
    //生产商名称
    private String producerName;
    //制造商code
    private String manufacturerCode;
    //制造商名称
    private String manufacturerName;
    //订单冲抵库存来源
    private String invSource;
    //买家订单明细（产品的货主信息）
    private List<FmsBuyerOrderStock> subLine;

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public BigDecimal getUnitSellingPriceDsp() {
        return unitSellingPriceDsp;
    }

    public void setUnitSellingPriceDsp(BigDecimal unitSellingPriceDsp) {
        this.unitSellingPriceDsp = unitSellingPriceDsp;
    }

    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getInvSource() {
        return invSource;
    }

    public void setInvSource(String invSource) {
        this.invSource = invSource;
    }

    public List<FmsBuyerOrderStock> getSubLine() {
        return subLine;
    }

    public void setSubLine(List<FmsBuyerOrderStock> subLine) {
        this.subLine = subLine;
    }
}
