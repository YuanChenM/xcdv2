package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0019.
 * <p>
 * Fms买家退货订单Detail
 */
public class FmsBuyerReturnOrderDetail implements Serializable {
    private static final long serialVersionUID = 1038975383084777636L;
    //对应买家订单的行编号
    private int buyerOrderLineNum;
    //订购项目
    private String productId;
    //订单数量，退货数量
    private BigDecimal orderedQuantity;
    //退货原因ID
    private String reasonId;
    //单位 "OMS Master数据"
    private String salesUnit;
    //sku
    private String sku;
    //生产商code
    private String pdrsCode;
    //生产商名称
    private String prdsName;
    //制造商code
    private String mfrsCode;
    //退货单价
    private BigDecimal returnPrice;
    //制造商名称
    private String mfrsName;
    //subLine
    private List<FmsBuyerReturnOrderStock> subLine;

    public int getBuyerOrderLineNum() {
        return buyerOrderLineNum;
    }

    public void setBuyerOrderLineNum(int buyerOrderLineNum) {
        this.buyerOrderLineNum = buyerOrderLineNum;
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

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPdrsCode() {
        return pdrsCode;
    }

    public void setPdrsCode(String pdrsCode) {
        this.pdrsCode = pdrsCode;
    }

    public String getPrdsName() {
        return prdsName;
    }

    public void setPrdsName(String prdsName) {
        this.prdsName = prdsName;
    }

    public String getMfrsCode() {
        return mfrsCode;
    }

    public void setMfrsCode(String mfrsCode) {
        this.mfrsCode = mfrsCode;
    }

    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    public String getMfrsName() {
        return mfrsName;
    }

    public void setMfrsName(String mfrsName) {
        this.mfrsName = mfrsName;
    }

    public List<FmsBuyerReturnOrderStock> getSubLine() {
        return subLine;
    }

    public void setSubLine(List<FmsBuyerReturnOrderStock> subLine) {
        this.subLine = subLine;
    }
}
