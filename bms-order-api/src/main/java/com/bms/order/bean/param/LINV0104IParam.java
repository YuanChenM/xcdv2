package com.bms.order.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/18.
 */
@ApiModel(value = "LINV0104IParam",
        description = "产品库存占用取消请求类")
public class LINV0104IParam implements Serializable{
    public static String TRANSACTION_TYPE = "104";

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

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
