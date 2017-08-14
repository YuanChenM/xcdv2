package com.bms.linv.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wang_fan on 2017/4/18.
 */
@ApiModel(value = "LINV0102IDealParam",
    description = "销售发货Deal参数")
public class LINV0102IDealParam implements Serializable {
    @ApiModelProperty(value = "参考号")
    private String refNo;
    @ApiModelProperty(value = "业务单ID")
    private Long transactionId;
    @ApiModelProperty(value = "业务单号")
    private String transactionNo;
    @ApiModelProperty(value = "业务明细ID")
    private Long transactionDetailId;
    @ApiModelProperty(value = "业务校验序列")
    private Integer transactionSequence;
    @ApiModelProperty(value = "业务源")
    private String transactionSource;
    @ApiModelProperty(value = "目标方Id")
    private String targetId;
    @ApiModelProperty(value = "目标方编码")
    private String targetCode;
    @ApiModelProperty(value = "目标方类型")
    private String targetType;
    @ApiModelProperty(value = "销售价格")
    private BigDecimal sellPrice;
    @ApiModelProperty(value = "占用释放数量")
    private BigDecimal releaseQty;
    @ApiModelProperty(value = "发货数量")
    private BigDecimal dispatchedQty;
    @ApiModelProperty(value = "业务类型")
    private String bizType;
    @ApiModelProperty(value = "原占用业务单ID")
    private Long releaseTransactionId;
    @ApiModelProperty(value = "原占用业务单号")
    private String releaseTransactionNo;
    @ApiModelProperty(value = "原占用业务明细ID")
    private Long releaseTransactionDetailId;


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

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
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

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public BigDecimal getDispatchedQty() {
        return dispatchedQty;
    }

    public void setDispatchedQty(BigDecimal dispatchedQty) {
        this.dispatchedQty = dispatchedQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getReleaseTransactionId() {
        return releaseTransactionId;
    }

    public void setReleaseTransactionId(Long releaseTransactionId) {
        this.releaseTransactionId = releaseTransactionId;
    }

    public String getReleaseTransactionNo() {
        return releaseTransactionNo;
    }

    public void setReleaseTransactionNo(String releaseTransactionNo) {
        this.releaseTransactionNo = releaseTransactionNo;
    }

    public Long getReleaseTransactionDetailId() {
        return releaseTransactionDetailId;
    }

    public void setReleaseTransactionDetailId(Long releaseTransactionDetailId) {
        this.releaseTransactionDetailId = releaseTransactionDetailId;
    }
}