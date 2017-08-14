package com.batch.order.bean.result;

import java.io.Serializable;

/**
 * Created by sunjiaju on 2017/03/20.
 */
public class OrderBatchEmailResult implements Serializable {
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private String orderCode;

    private String batchNo;

    private String errorMessage;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
