package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/2.
 */
public class LINV0007IAllocation implements Serializable {
    //参考号
    private String refNo;
    //业务单ID
    private Long transactionId;
    //业务单号
    private String transactionNo;
    //业务源
    private String transactionSource;
    //业务明细ID
    private Long transactionDetailId;
    //业务单号
    private Integer transactionSequence;
    //占用数量
    private BigDecimal allocatedQty;
    //占用类型
    private String allocatedType;
    //目标方Id
    private String targetId;
    //目标方编码
    private String targetCode;
    //目标方类型
    private String targetType;

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
}
