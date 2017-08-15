package com.bms.order.fms.bean;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuan_chen on 2017/5/5
 */
@ApiModel(value = "OmsProductInventoryBean",
    description = "商品库存交易溯源信息查询出参")
public class OmsProductInventoryBean implements Serializable {
    private static final long serialVersionUID = 1329171931795062716L;
    //物流区域ID
    private String logisticsId;
    //货主ID
    private String ownerId;
    //货主编码
    private String ownerCode;
    //货主类型
    private String ownerType;
    //目标方ID
    private String targetId;
    //目标方编码
    private String targetCode;
    //目标方类型
    private String targetType;
    //业务类型
    private String bizType;
    //被查询的业务单ID
    private Long transactionId;
    //被查询的业务单号
    private String transactionNo;
    //被查询的业务单对应的模块编号
    private String transactionSource;
    //被查询的业务单对应的业务明细ID
    private Long transactionDetailId;
    //交易商品ID
    private String commodityId;
    //交易商品名称
    private String commodityName;
    //交易单位
    private String uom;
    //库存类型
    private String ivType;
    //交易数量
    private BigDecimal dealQty;
    //交易价格
    private BigDecimal dealPrice;
    //交易商品对应的源入库明细
    private List<OmsProductInventoryDetail> srcList;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }


    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public BigDecimal getDealQty() {
        return dealQty;
    }

    public void setDealQty(BigDecimal dealQty) {
        this.dealQty = dealQty;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public List<OmsProductInventoryDetail> getSrcList() {
        return srcList;
    }

    public void setSrcList(List<OmsProductInventoryDetail> srcList) {
        this.srcList = srcList;
    }
}
