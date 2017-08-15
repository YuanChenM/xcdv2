package com.bms.order.fms.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yuan_chen on 2017/5/4.
 * 
 * OmsProductInventoryDetail
 */
public class OmsProductInventoryDetail implements Serializable {
    private static final long serialVersionUID = -4355793338158763896L;
    //源业务单库存货权人ID
    private String srcOwnerId;
    //源业务单库存货权人编码
    private String srcOwnerCode;
    //源业务单商品ID
    private Long srcCommodityId;
    //源业务单商品库存存储单位
    private String srcUom;
    //源业务单库存状态
    private String srcIvType;
    //源业务单商品库存状态
    private String srcComoInvType;
    //源业务单ID
    private Long srcTransactionId;
    //源业务单单号
    private String srcTransactionNo;
    //源业务单对应的业务明细ID
    private Long srcTransactionDetailId;
    //源业务单商品原入库价格
    private BigDecimal srcDealPrice;
    //源业务单商品针对本交易的出货数量
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
