/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_como_balance_inventory对应的实体InvmComoBalanceInventory</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoBalanceInventory extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 库存记录ID */
    private Long invId;
    /** 交易ID */
    private Long storeDealId;
    /** 商品库存身份编号 */
    private String storeNo;
    /** 业务单ID */
    private Long transactionId;
    /** 业务单号 */
    private String transactionNo;
    /** 业务单明细ID */
    private Long transactionDetailId;
    /** 模块编号，例如订单模块编号 */
    private String transactionSource;
    /** 接口编号 */
    private String transactionType;
    /** 业务发生时间 */
    private java.util.Date transactionTime;
    /** 参考号 */
    private String refNo;
    /** 业务类型，Master数据 */
    private String bizType;
    /** 交易发生价格 */
    private java.math.BigDecimal dealPrice;
    /** 原入库数量 */
    private java.math.BigDecimal inboundQty;
    /** 已出库数量，剩余可用库存 = 原入库数量-已出库数量 */
    private java.math.BigDecimal outboundQty;
    /** 来源方ID */
    private String srcId;
    /** 来源方编码 */
    private String srcCode;
    /** 来源方类型 */
    private String srcType;

    public Long getStoreDealId() {
        return storeDealId;
    }

    public void setStoreDealId(Long storeDealId) {
        this.storeDealId = storeDealId;
    }

    /**
     * <p>默认构造函数</p>
     */
    public InvmComoBalanceInventory() {
    }

    /**
     * <p>库存记录ID</p>
     *
     * @return 库存记录ID
     */
    public Long getInvId() {
        return invId;
    }

    /**
     * <p>库存记录ID</p>
     *
     * @param invId 库存记录ID
     */
    public void setInvId(Long invId) {
        this.invId = invId;
    }
    /**
     * <p>商品库存身份编号</p>
     *
     * @return 商品库存身份编号
     */
    public String getStoreNo() {
        return storeNo;
    }

    /**
     * <p>商品库存身份编号</p>
     *
     * @param storeNo 商品库存身份编号
     */
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    /**
     * <p>业务单ID</p>
     *
     * @return 业务单ID
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * <p>业务单ID</p>
     *
     * @param transactionId 业务单ID
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * <p>业务单号</p>
     *
     * @return 业务单号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * <p>业务单号</p>
     *
     * @param transactionNo 业务单号
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }
    /**
     * <p>业务单明细ID</p>
     *
     * @return 业务单明细ID
     */
    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    /**
     * <p>业务单明细ID</p>
     *
     * @param transactionDetailId 业务单明细ID
     */
    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }
    /**
     * <p>模块编号，例如订单模块编号</p>
     *
     * @return 模块编号，例如订单模块编号
     */
    public String getTransactionSource() {
        return transactionSource;
    }

    /**
     * <p>模块编号，例如订单模块编号</p>
     *
     * @param transactionSource 模块编号，例如订单模块编号
     */
    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }
    /**
     * <p>接口编号</p>
     *
     * @return 接口编号
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * <p>接口编号</p>
     *
     * @param transactionType 接口编号
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    /**
     * <p>业务发生时间</p>
     *
     * @return 业务发生时间
     */
    public java.util.Date getTransactionTime() {
        return transactionTime;
    }

    /**
     * <p>业务发生时间</p>
     *
     * @param transactionTime 业务发生时间
     */
    public void setTransactionTime(java.util.Date transactionTime) {
        this.transactionTime = transactionTime;
    }
    /**
     * <p>参考号</p>
     *
     * @return 参考号
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * <p>参考号</p>
     *
     * @param refNo 参考号
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
    /**
     * <p>业务类型，Master数据</p>
     *
     * @return 业务类型，Master数据
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * <p>业务类型，Master数据</p>
     *
     * @param bizType 业务类型，Master数据
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    /**
     * <p>交易发生价格</p>
     *
     * @return 交易发生价格
     */
    public java.math.BigDecimal getDealPrice() {
        return dealPrice;
    }

    /**
     * <p>交易发生价格</p>
     *
     * @param dealPrice 交易发生价格
     */
    public void setDealPrice(java.math.BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }
    /**
     * <p>原入库数量</p>
     *
     * @return 原入库数量
     */
    public java.math.BigDecimal getInboundQty() {
        return inboundQty;
    }

    /**
     * <p>原入库数量</p>
     *
     * @param inboundQty 原入库数量
     */
    public void setInboundQty(java.math.BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }
    /**
     * <p>已出库数量，剩余可用库存 = 原入库数量-已出库数量</p>
     *
     * @return 已出库数量，剩余可用库存 = 原入库数量-已出库数量
     */
    public java.math.BigDecimal getOutboundQty() {
        return outboundQty;
    }

    /**
     * <p>已出库数量，剩余可用库存 = 原入库数量-已出库数量</p>
     *
     * @param outboundQty 已出库数量，剩余可用库存 = 原入库数量-已出库数量
     */
    public void setOutboundQty(java.math.BigDecimal outboundQty) {
        this.outboundQty = outboundQty;
    }
    /**
     * <p>来源方ID</p>
     *
     * @return 来源方ID
     */
    public String getSrcId() {
        return srcId;
    }

    /**
     * <p>来源方ID</p>
     *
     * @param srcId 来源方ID
     */
    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }
    /**
     * <p>来源方编码</p>
     *
     * @return 来源方编码
     */
    public String getSrcCode() {
        return srcCode;
    }

    /**
     * <p>来源方编码</p>
     *
     * @param srcCode 来源方编码
     */
    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }
    /**
     * <p>来源方类型</p>
     *
     * @return 来源方类型
     */
    public String getSrcType() {
        return srcType;
    }

    /**
     * <p>来源方类型</p>
     *
     * @param srcType 来源方类型
     */
    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

}
