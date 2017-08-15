package com.bms.order.external.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ni_shaotang on 2017/3/15.
 */
public class LINV0010IDeal implements Serializable {
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
    //释放数量
    private BigDecimal releaseQty;

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

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }
}
