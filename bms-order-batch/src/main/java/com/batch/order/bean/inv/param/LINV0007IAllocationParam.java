package com.batch.order.bean.inv.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by liutao on 2017/3/7.
 */
public class LINV0007IAllocationParam implements Serializable {
    private static final long serialVersionUID = 1L;

    private String refNo;

    private Long transactionId;

    private String transactionNo;

    private String transactionSource;

    private Long transactionDetailId;

    private Integer transactionSequence;

    private String targetId;

    private String targetCode;

    private String targetType;

    private BigDecimal allocatedQty;

    private String allocatedType;

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

    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
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

    public BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public String getAllocatedType() {
        return allocatedType;
    }

    public void setAllocatedType(String allocatedType) {
        this.allocatedType = allocatedType;
    }
}
