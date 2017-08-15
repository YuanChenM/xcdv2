package com.bms.order.external.bean.param;

import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/16.
 */
public class LINV0008IRestParam {
    //业务单ID
    private Long transactionId;
    //业务单号
    private String transactionNo;
    //业务明细ID
    private Long transactionDetailId;
    //业务校验序列
    private Integer transactionSequence;
    //取消数量
    private BigDecimal cancelQty;
    // 占用类型
    private String alocType;

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

    public BigDecimal getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(BigDecimal cancelQty) {
        this.cancelQty = cancelQty;
    }

    /**
     * @return the alocType
     */
    public String getAlocType() {
        return alocType;
    }

    /**
     * @param alocType
     *            the alocType to set
     */
    public void setAlocType(String alocType) {
        this.alocType = alocType;
    }

}
