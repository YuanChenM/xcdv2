package com.bms.order.external.bean.param;

import java.math.BigDecimal;

/**
 * Created by zheng_xu on 2017/4/17.
 */
public class LINV0107IAllocationParam {
    private String refNo;
    private Long transactionId;
    private String transactionNo;
    private String transactionSource;
    private Long transactionDetailId;
    private int transactionSequence;
    private String targetId;
    private String targetCode;
    private String targetType;
    private BigDecimal alocQty;
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

    public int getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(int transactionSequence) {
        this.transactionSequence = transactionSequence;
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

    public BigDecimal getAlocQty() {
        return alocQty;
    }

    public void setAlocQty(BigDecimal alocQty) {
        this.alocQty = alocQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
