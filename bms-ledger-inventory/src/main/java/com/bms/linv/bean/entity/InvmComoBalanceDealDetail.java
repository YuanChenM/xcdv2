/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_como_balance_deal_detail对应的实体InvmComoBalanceDealDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoBalanceDealDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 记录ID */
    private Long detailId;
    /** 交易ID */
    private Long storeDealId;
    /** 库存余量表库存记录ID */
    private Long balanceInvId;
    /** 货权人ID */
    private String ownerId;
    /** 源业务单ID，对应余量表中的业务单据号 */
    private Long srcTransactionId;
    /** 源业务单编码，对应余量表中的业务单据编码 */
    private String srcTransactionNo;
    /** 源业务单明细ID */
    private Long srcTransactionDetailId;
    /** 原业务明细变动的数量 */
    private java.math.BigDecimal dealQty;

    /**
     * <p>默认构造函数</p>
     */
    public InvmComoBalanceDealDetail() {
    }

    /**
     * <p>记录ID</p>
     *
     * @return 记录ID
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * <p>记录ID</p>
     *
     * @param detailId 记录ID
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    /**
     * <p>交易ID</p>
     *
     * @return 交易ID
     */
    public Long getStoreDealId() {
        return storeDealId;
    }

    /**
     * <p>交易ID</p>
     *
     * @param storeDealId 交易ID
     */
    public void setStoreDealId(Long storeDealId) {
        this.storeDealId = storeDealId;
    }
    /**
     * <p>货权人ID</p>
     *
     * @return 货权人ID
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * <p>货权人ID</p>
     *
     * @param ownerId 货权人ID
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * <p>源业务单ID，对应余量表中的业务单据号</p>
     *
     * @return 源业务单ID，对应余量表中的业务单据号
     */
    public Long getSrcTransactionId() {
        return srcTransactionId;
    }

    /**
     * <p>源业务单ID，对应余量表中的业务单据号</p>
     *
     * @param srcTransactionId 源业务单ID，对应余量表中的业务单据号
     */
    public void setSrcTransactionId(Long srcTransactionId) {
        this.srcTransactionId = srcTransactionId;
    }
    /**
     * <p>源业务单明细ID</p>
     *
     * @return 源业务单明细ID
     */
    public Long getSrcTransactionDetailId() {
        return srcTransactionDetailId;
    }

    /**
     * <p>源业务单明细ID</p>
     *
     * @param srcTransactionDetailId 源业务单明细ID
     */
    public void setSrcTransactionDetailId(Long srcTransactionDetailId) {
        this.srcTransactionDetailId = srcTransactionDetailId;
    }
    /**
     * <p>原业务明细变动的数量</p>
     *
     * @return 原业务明细变动的数量
     */
    public java.math.BigDecimal getDealQty() {
        return dealQty;
    }

    /**
     * <p>原业务明细变动的数量</p>
     *
     * @param dealQty 原业务明细变动的数量
     */
    public void setDealQty(java.math.BigDecimal dealQty) {
        this.dealQty = dealQty;
    }

    public Long getBalanceInvId() {
        return balanceInvId;
    }

    public void setBalanceInvId(Long balanceInvId) {
        this.balanceInvId = balanceInvId;
    }

    public String getSrcTransactionNo() {
        return srcTransactionNo;
    }

    public void setSrcTransactionNo(String srcTransactionNo) {
        this.srcTransactionNo = srcTransactionNo;
    }
}
