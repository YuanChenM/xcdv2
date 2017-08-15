package com.bms.order.bean.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guan_zhongheng on 2017/4/27.
 */
public class LINV0105IDealParam implements Serializable{

    @ApiModelProperty(value = "是否扣减货权方商品库存")
    private boolean deductSrcInv;
    @ApiModelProperty(value = "是否增加目标方商品库存")
    private boolean addTargetInv;
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
    @ApiModelProperty(value = "目标方名称")
    private String targetName;
    @ApiModelProperty(value = "目标方类型")
    private String targetType;
    @ApiModelProperty(value = "采购单价")
    private BigDecimal dealPrice;
    @ApiModelProperty(value = "释放数量")
    private BigDecimal releaseQty;
    @ApiModelProperty(value = "交易数量")
    private BigDecimal dealQty;
    @ApiModelProperty(value = "业务类型")
    private String bizType;


    public boolean isDeductSrcInv() {
        return deductSrcInv;
    }

    public void setDeductSrcInv(boolean deductSrcInv) {
        this.deductSrcInv = deductSrcInv;
    }

    public boolean isAddTargetInv() {
        return addTargetInv;
    }

    public void setAddTargetInv(boolean addTargetInv) {
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

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
    }

    public BigDecimal getDealQty() {
        return dealQty;
    }

    public void setDealQty(BigDecimal dealQty) {
        this.dealQty = dealQty;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
