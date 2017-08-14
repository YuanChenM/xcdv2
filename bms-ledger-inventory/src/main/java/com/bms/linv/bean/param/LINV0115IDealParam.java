package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
public class LINV0115IDealParam implements Serializable {

    public static String TRANSACTION_TYPE = "115";

    @ApiModelProperty(value = "参考号")
    private String refNo;
    @ApiModelProperty(value = "业务单ID")
    private Long transactionId;
    @ApiModelProperty(value = "业务单号")
    private String transactionNo;
    @ApiModelProperty(value = "调用模块")
    private String transactionSource;
    @ApiModelProperty(value = "业务明细ID")
    private Long transactionDetailId;
    @ApiModelProperty(value = "业务校验序列")
    private Integer transactionSequence;
    @ApiModelProperty(value = "新商品ID")
    private Long newCommodityId;
    @ApiModelProperty(value = "交易数量")
    private BigDecimal transferQty;
    @ApiModelProperty(value = "业务类型")
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

    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }

    public Long getNewCommodityId() {
        return newCommodityId;
    }

    public void setNewCommodityId(Long newCommodityId) {
        this.newCommodityId = newCommodityId;
    }

    public BigDecimal getTransferQty() {
        return transferQty;
    }

    public void setTransferQty(BigDecimal transferQty) {
        this.transferQty = transferQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
