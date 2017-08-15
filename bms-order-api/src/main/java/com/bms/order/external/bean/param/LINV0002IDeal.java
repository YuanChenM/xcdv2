package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/9.
 */
public class LINV0002IDeal implements Serializable {
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
    //业务校验序列
    private Integer transactionSequence;
    //目标方Id
    private String targetId;
    //目标方编码
    private String targetCode;
    //目标方类型
    private String targetType;
    //否涉及实货囤货
    private String isStoreFlag;
    //销售价格
    private BigDecimal sellPrice;
    //单据数量
    private BigDecimal orderQty;
    //发货数量
    private BigDecimal dispatchedQty;
    //占用类型
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

    public String getIsStoreFlag() {
        return isStoreFlag;
    }

    public void setIsStoreFlag(String isStoreFlag) {
        this.isStoreFlag = isStoreFlag;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getDispatchedQty() {
        return dispatchedQty;
    }

    public void setDispatchedQty(BigDecimal dispatchedQty) {
        this.dispatchedQty = dispatchedQty;
    }

    public String getAllocatedType() {
        return allocatedType;
    }

    public void setAllocatedType(String allocatedType) {
        this.allocatedType = allocatedType;
    }
}
