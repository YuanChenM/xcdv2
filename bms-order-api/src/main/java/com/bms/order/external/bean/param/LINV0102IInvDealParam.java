package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/18.
 */
public class LINV0102IInvDealParam implements Serializable {
    private String refNo;
    private Long transactionId;
    private String transactionNo;
    private Long transactionDetailId;
    private Integer transactionSequence;
    private String transactionSource;
    private String targetId;
    private String targetCode;
    private String targetType;
    private BigDecimal sellPrice;
    private BigDecimal releaseQty;
    private BigDecimal dispatchedQty;
    private String bizType;
    private Long releaseTransactionId;
    private String releaseTransactionNo;
    private Long releaseTransactionDetailId;

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

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public BigDecimal getDispatchedQty() {
        return dispatchedQty;
    }

    public void setDispatchedQty(BigDecimal dispatchedQty) {
        this.dispatchedQty = dispatchedQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getReleaseTransactionId() {
        return releaseTransactionId;
    }

    public void setReleaseTransactionId(Long releaseTransactionId) {
        this.releaseTransactionId = releaseTransactionId;
    }

    public String getReleaseTransactionNo() {
        return releaseTransactionNo;
    }

    public void setReleaseTransactionNo(String releaseTransactionNo) {
        this.releaseTransactionNo = releaseTransactionNo;
    }

    public Long getReleaseTransactionDetailId() {
        return releaseTransactionDetailId;
    }

    public void setReleaseTransactionDetailId(Long releaseTransactionDetailId) {
        this.releaseTransactionDetailId = releaseTransactionDetailId;
    }
}