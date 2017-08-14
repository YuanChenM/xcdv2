package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zheng_xu on 2017/4/25.
 */
@ApiModel(value = "LINV0116IParam",
    description = "商品库存交易溯源信息查询入参")
public class LINV0116IParam implements Serializable {
    @ApiModelProperty(value = "物流区域ID")
    private String logisticsId;
    @ApiModelProperty(value = "出货货权人ID")
    private String ownerId;
    @ApiModelProperty(value = "出货货权人编码")
    private String ownerCode;
    @ApiModelProperty(value = "出货货权人类型")
    private String ownerType;
    @ApiModelProperty(value = "收货货权人ID")
    private String targetId;
    @ApiModelProperty(value = "收货货权人编码")
    private String targetCode;
    @ApiModelProperty(value = "收货货权人类型")
    private String targetType;
    @ApiModelProperty(value = "业务类型")
    private String bizType;
    @ApiModelProperty(value = "业务单ID")
    private Long transactionId;
    @ApiModelProperty(value = "业务单号")
    private String transactionNo;
    @ApiModelProperty(value = "模块编号")
    private String transactionSource;
    @ApiModelProperty(value = "业务明细ID")
    private Long transactionDetailId;
    @ApiModelProperty(value = "商品ID")
    private String commodityId;
    @ApiModelProperty(value = "单位")
    private String uom;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
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

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
