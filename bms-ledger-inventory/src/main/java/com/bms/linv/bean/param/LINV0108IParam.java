package com.bms.linv.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/19.
 */
@ApiModel(value = "LINV0108IParam",
    description = "商品占用取消接口")
public class LINV0108IParam implements Serializable {
    public static String TRANSACTION_TYPE = "108";

    @ApiModelProperty(value = "业务单ID")
    private Long transactionId;

    @ApiModelProperty(value = "业务单号")
    private String transactionNo;

    @ApiModelProperty(value = "业务明细ID")
    private Long transactionDetailId;

    @ApiModelProperty(value = "模块编号")
    private String transactionSource;

    @ApiModelProperty(value = "业务校验序列")
    private Integer transactionSequence;

    @ApiModelProperty(value = "取消数量")
    private BigDecimal cancelQty;

    @ApiModelProperty(value = "业务类型")
    private String bizType;

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

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public BigDecimal getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(BigDecimal cancelQty) {
        this.cancelQty = cancelQty;
    }

    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}