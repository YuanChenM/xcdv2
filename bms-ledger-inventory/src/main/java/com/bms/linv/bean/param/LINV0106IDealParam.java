package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wang_haichun on 2017/4/17.
 */
public class LINV0106IDealParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否增加目标方商品库存")
    private Boolean addTargetInv;
    @ApiModelProperty(value = "是否扣减货权方商品库存")
    private Boolean deductSrcInv;
    @ApiModelProperty(value = "参考号")
    private String refNo;
    @ApiModelProperty(value = "业务单ID")
    private Long transactionId;
    @ApiModelProperty(value = "业务单号")
    private String transactionNo;
    @ApiModelProperty(value = "模块编号")
    private String transactionSource;
    @ApiModelProperty(value = "业务明细ID")
    private Long transactionDetailId;
    @ApiModelProperty(value = "业务校验序列")
    private Integer transactionSequence;
    @ApiModelProperty(value = "退货目标方ID")
    private String targetId;
    @ApiModelProperty(value = "退货目标方编码")
    private String targetCode;
    @ApiModelProperty(value = "退货目标方类型")
    private String targetType;
    @ApiModelProperty(value = "占用释放数量")
    private BigDecimal releaseQty;
    @ApiModelProperty(value = "交易发生价格")
    private BigDecimal returnPrice;
    @ApiModelProperty(value = "退货数量")
    private BigDecimal returnQty;
    @ApiModelProperty(value = "业务类型")
    private String bizType;
    @ApiModelProperty(value = "原交易单ID")
    private Long srcTransactionId;
    @ApiModelProperty(value = "原交易单号")
    private String srcTransactionNo;
    @ApiModelProperty(value = "原交易明细ID")
    private Long srcTransactionDetailId;


    public Boolean getDeductSrcInv() {
        return deductSrcInv;
    }

    public void setDeductSrcInv(Boolean deductSrcInv) {
        this.deductSrcInv = deductSrcInv;
    }

    public Boolean getAddTargetInv() {
        return addTargetInv;
    }

    public void setAddTargetInv(Boolean addTargetInv) {
        this.addTargetInv = addTargetInv;
    }

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

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getSrcTransactionId() {
        return srcTransactionId;
    }

    public void setSrcTransactionId(Long srcTransactionId) {
        this.srcTransactionId = srcTransactionId;
    }

    public Long getSrcTransactionDetailId() {
        return srcTransactionDetailId;
    }

    public void setSrcTransactionDetailId(Long srcTransactionDetailId) {
        this.srcTransactionDetailId = srcTransactionDetailId;
    }

    public String getSrcTransactionNo() {
        return srcTransactionNo;
    }

    public void setSrcTransactionNo(String srcTransactionNo) {
        this.srcTransactionNo = srcTransactionNo;
    }
}
