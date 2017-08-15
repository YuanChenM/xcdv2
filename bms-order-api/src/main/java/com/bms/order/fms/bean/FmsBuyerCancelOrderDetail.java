package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 *
 * Fms买家取消订单Detail
 */
public class FmsBuyerCancelOrderDetail implements Serializable {
    private static final long serialVersionUID = -2799630399692818660L;
    //行编号
    private int lineNum;
    //订购项目
    private String productId;
    //行状态
    private String lineStatus;
    //取消数量
    private BigDecimal cancelQuantity;
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
    //subLine
    private List<FmsBuyerCancelOrderStock> subLine;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
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

    public List<FmsBuyerCancelOrderStock> getSubLine() {
        return subLine;
    }

    public void setSubLine(List<FmsBuyerCancelOrderStock> subLine) {
        this.subLine = subLine;
    }
}
