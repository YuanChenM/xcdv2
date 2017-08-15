package com.bms.order.external.bean.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zheng_xu on 2017/4/25.
 */
public class LINV0116ISrcListResult implements Serializable {
    private String srcOwnerId;
    private String srcOwnerCode;
    private Long srcCommodityId;
    private String srcUom;
    private String srcIvType;
    private String srcComoInvType;
    private Long srcTransactionId;
    private String srcTransactionNo;
    private Long srcTransactionDetailId;
    private BigDecimal srcDealPrice;
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
