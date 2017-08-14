package com.bms.puch.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/21.
 */
public class LINV0101IDealParam implements Serializable{

    /** 参考号*/
    private String refNo;
    /** 业务单ID*/
    private Long transactionId;
    /** 业务单号*/
    private String transactionNo;
    /** 业务明细ID*/
    private Long transactionDetailId;
    /** 业务校验序列*/
    private Integer transactionSequence;
    /** 业务源*/
    private String transactionSource;
    /** 供应商Id*/
    private String supplierId;
    /** 供应商编码*/
    private String supplierCode;
    /** 供应商名称*/
    private String supplierName;
    /** 采购批次*/
    private String lotNo;
    /** 采购单价*/
    private BigDecimal buyPrice;
    /** 收货数量*/
    private BigDecimal recvQty;
    /** 库存类型*/
    private String ivType;
    /** 销售状态id*/
    private Long salesStatusId;
    /** 销售状态编码*/
    private String salesStatusCode;
    /** 业务类型*/
    private String bizType;

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
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

    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getRecvQty() {
        return recvQty;
    }

    public void setRecvQty(BigDecimal recvQty) {
        this.recvQty = recvQty;
    }

    public String getIvType() {
        return ivType;
    }

    public void setIvType(String ivType) {
        this.ivType = ivType;
    }

    public Long getSalesStatusId() {
        return salesStatusId;
    }

    public void setSalesStatusId(Long salesStatusId) {
        this.salesStatusId = salesStatusId;
    }

    public String getSalesStatusCode() {
        return salesStatusCode;
    }

    public void setSalesStatusCode(String salesStatusCode) {
        this.salesStatusCode = salesStatusCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
