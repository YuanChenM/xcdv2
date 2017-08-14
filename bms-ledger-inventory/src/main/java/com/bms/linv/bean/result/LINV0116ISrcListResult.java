package com.bms.linv.bean.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zheng_xu on 2017/4/25.
 */
public class LINV0116ISrcListResult implements Serializable {
    @ApiModelProperty(value = "源业务单库存货权人ID")
    private String srcOwnerId;
    @ApiModelProperty(value = "源业务单库存货权人编码")
    private String srcOwnerCode;
    @ApiModelProperty(value = "源业务单商品ID")
    private Long srcCommodityId;
    @ApiModelProperty(value = "源业务单商品库存存储单位")
    private String srcUom;
    @ApiModelProperty(value = "源业务单库存状态")
    private String srcIvType;
    @ApiModelProperty(value = "源业务单商品库存状态")
    private String srcComoInvType;
    @ApiModelProperty(value = "源业务单ID")
    private Long srcTransactionId;
    @ApiModelProperty(value = "源业务单单号")
    private String srcTransactionNo;
    @ApiModelProperty(value = "源业务单对应的业务明细ID")
    private Long srcTransactionDetailId;
    @ApiModelProperty(value = "源业务单商品原入库价格")
    private BigDecimal srcDealPrice;
    @ApiModelProperty(value = "源业务单商品针对本交易的出货数量")
    private BigDecimal srcDealQty;

    public String getSrcOwnerId() {
        return srcOwnerId;
    }

    public void setSrcOwnerId(String srcOwnerId) {
        this.srcOwnerId = srcOwnerId;
    }

    public String getSrcOwnerCode() {
        return srcOwnerCode;
    }

    public void setSrcOwnerCode(String srcOwnerCode) {
        this.srcOwnerCode = srcOwnerCode;
    }

    public Long getSrcCommodityId() {
        return srcCommodityId;
    }

    public void setSrcCommodityId(Long srcCommodityId) {
        this.srcCommodityId = srcCommodityId;
    }

    public String getSrcUom() {
        return srcUom;
    }

    public void setSrcUom(String srcUom) {
        this.srcUom = srcUom;
    }

    public String getSrcIvType() {
        return srcIvType;
    }

    public void setSrcIvType(String srcIvType) {
        this.srcIvType = srcIvType;
    }

    public String getSrcComoInvType() {
        return srcComoInvType;
    }

    public void setSrcComoInvType(String srcComoInvType) {
        this.srcComoInvType = srcComoInvType;
    }

    public Long getSrcTransactionId() {
        return srcTransactionId;
    }

    public void setSrcTransactionId(Long srcTransactionId) {
        this.srcTransactionId = srcTransactionId;
    }

    public String getSrcTransactionNo() {
        return srcTransactionNo;
    }

    public void setSrcTransactionNo(String srcTransactionNo) {
        this.srcTransactionNo = srcTransactionNo;
    }

    public Long getSrcTransactionDetailId() {
        return srcTransactionDetailId;
    }

    public void setSrcTransactionDetailId(Long srcTransactionDetailId) {
        this.srcTransactionDetailId = srcTransactionDetailId;
    }

    public BigDecimal getSrcDealPrice() {
        return srcDealPrice;
    }

    public void setSrcDealPrice(BigDecimal srcDealPrice) {
        this.srcDealPrice = srcDealPrice;
    }

    public BigDecimal getSrcDealQty() {
        return srcDealQty;
    }

    public void setSrcDealQty(BigDecimal srcDealQty) {
        this.srcDealQty = srcDealQty;
    }
}
