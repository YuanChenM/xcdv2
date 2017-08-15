package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/18.
 */
public class LINV0105IInvDealParam implements Serializable {
    private boolean deductSrcInv;
    private boolean addTargetInv;
    private String refNo;
    private Long transactionId;
    private String transactionNo;
    private Long transactionDetailId;
    private Integer transactionSequence;
    private String transactionSource;
    private String targetId;
    private String targetCode;
    private String targetType;
    private String targetName;
    private BigDecimal dealPrice;
    private BigDecimal releaseQty;
    private BigDecimal dealQty;
    private String bizType;

    public boolean isAddTargetInv() {
        return addTargetInv;
    }

    public void setAddTargetInv(boolean addTargetInv) {
        this.addTargetInv = addTargetInv;
    }

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

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public BigDecimal getDealQty() {
        return dealQty;
    }

    public void setDealQty(BigDecimal dealQty) {
        this.dealQty = dealQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public boolean isDeductSrcInv() {
        return deductSrcInv;
    }

    public void setDeductSrcInv(boolean deductSrcInv) {
        this.deductSrcInv = deductSrcInv;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}