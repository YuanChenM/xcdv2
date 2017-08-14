/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_load_deal_detail对应的实体InvmLoadDealDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmLoadDealDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 交易明细ID */
    private Long loadDealId;
    /** 库存身份编号 */
    private String loadNo;
    /** 业务单ID，例如订单ID */
    private Long transactionId;
    /** 业务单号，例如订单编号 */
    private String transactionNo;
    /** 业务单明细ID，例如发货明细ID */
    private Long transactionDetailId;
    /** 业务校验序列 */
    private Integer transactionSequence;
    /** 模块编号 */
    private String transactionSource;
    /** 接口编号 */
    private String transactionType;
    /** 业务发生时间，默认当前时间 */
    private java.util.Date transactionTime;
    /** 参考号 */
    private String refNo;
    /** 业务类型，Master数据【20170411】 */
    private String bizType;
    /** WMS返回的出货供应商编码【20170411】 */
    private String spId;
    /** WMS返回的出货SKU【20170411】 */
    private String skuCode;
    /** WMS返回的出货采购批次【20170411】 */
    private String lotNo;
    /** WMS返回的出货销售状态【20170411】 */
    private Long saleStatusId;
    /** 交易数量 */
    private java.math.BigDecimal dealQty;
    /** 交易价格 */
    private java.math.BigDecimal dealPrice;
    /** 目标方ID */
    private String tgtId;
    /** 目标方编码 */
    private String tgtCode;
    /** 目标方类型，Master数据 */
    private String tgtType;

    /**
     * <p>默认构造函数</p>
     */
    public InvmLoadDealDetail() {
    }

    /**
     * <p>交易明细ID</p>
     *
     * @return 交易明细ID
     */
    public Long getLoadDealId() {
        return loadDealId;
    }

    /**
     * <p>交易明细ID</p>
     *
     * @param loadDealId 交易明细ID
     */
    public void setLoadDealId(Long loadDealId) {
        this.loadDealId = loadDealId;
    }
    /**
     * <p>库存身份编号</p>
     *
     * @return 库存身份编号
     */
    public String getLoadNo() {
        return loadNo;
    }

    /**
     * <p>库存身份编号</p>
     *
     * @param loadNo 库存身份编号
     */
    public void setLoadNo(String loadNo) {
        this.loadNo = loadNo;
    }
    /**
     * <p>业务单ID，例如订单ID</p>
     *
     * @return 业务单ID，例如订单ID
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * <p>业务单ID，例如订单ID</p>
     *
     * @param transactionId 业务单ID，例如订单ID
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * <p>业务单号，例如订单编号</p>
     *
     * @return 业务单号，例如订单编号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * <p>业务单号，例如订单编号</p>
     *
     * @param transactionNo 业务单号，例如订单编号
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }
    /**
     * <p>业务单明细ID，例如发货明细ID</p>
     *
     * @return 业务单明细ID，例如发货明细ID
     */
    public Long getTransactionDetailId() {
        return transactionDetailId;
    }

    /**
     * <p>业务单明细ID，例如发货明细ID</p>
     *
     * @param transactionDetailId 业务单明细ID，例如发货明细ID
     */
    public void setTransactionDetailId(Long transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }
    /**
     * <p>业务校验序列</p>
     *
     * @return 业务校验序列
     */
    public Integer getTransactionSequence() {
        return transactionSequence;
    }

    /**
     * <p>业务校验序列</p>
     *
     * @param transactionSequence 业务校验序列
     */
    public void setTransactionSequence(Integer transactionSequence) {
        this.transactionSequence = transactionSequence;
    }
    /**
     * <p>模块编号</p>
     *
     * @return 模块编号
     */
    public String getTransactionSource() {
        return transactionSource;
    }

    /**
     * <p>模块编号</p>
     *
     * @param transactionSource 模块编号
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
     * <p>业务发生时间，默认当前时间</p>
     *
     * @return 业务发生时间，默认当前时间
     */
    public java.util.Date getTransactionTime() {
        return transactionTime;
    }

    /**
     * <p>业务发生时间，默认当前时间</p>
     *
     * @param transactionTime 业务发生时间，默认当前时间
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
     * <p>业务类型，Master数据【20170411】</p>
     *
     * @return 业务类型，Master数据【20170411】
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * <p>业务类型，Master数据【20170411】</p>
     *
     * @param bizType 业务类型，Master数据【20170411】
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * <p>WMS返回的出货SKU【20170411】</p>
     *
     * @return WMS返回的出货SKU【20170411】
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>WMS返回的出货SKU【20170411】</p>
     *
     * @param skuCode WMS返回的出货SKU【20170411】
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>WMS返回的出货采购批次【20170411】</p>
     *
     * @return WMS返回的出货采购批次【20170411】
     */
    public String getLotNo() {
        return lotNo;
    }

    /**
     * <p>WMS返回的出货采购批次【20170411】</p>
     *
     * @param lotNo WMS返回的出货采购批次【20170411】
     */
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }
    /**
     * <p>WMS返回的出货销售状态【20170411】</p>
     *
     * @return WMS返回的出货销售状态【20170411】
     */
    public Long getSaleStatusId() {
        return saleStatusId;
    }

    /**
     * <p>WMS返回的出货销售状态【20170411】</p>
     *
     * @param saleStatusId WMS返回的出货销售状态【20170411】
     */
    public void setSaleStatusId(Long saleStatusId) {
        this.saleStatusId = saleStatusId;
    }
    /**
     * <p>交易数量</p>
     *
     * @return 交易数量
     */
    public java.math.BigDecimal getDealQty() {
        return dealQty;
    }

    /**
     * <p>交易数量</p>
     *
     * @param dealQty 交易数量
     */
    public void setDealQty(java.math.BigDecimal dealQty) {
        this.dealQty = dealQty;
    }
    /**
     * <p>交易价格</p>
     *
     * @return 交易价格
     */
    public java.math.BigDecimal getDealPrice() {
        return dealPrice;
    }

    /**
     * <p>交易价格</p>
     *
     * @param dealPrice 交易价格
     */
    public void setDealPrice(java.math.BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }
    /**
     * <p>目标方ID</p>
     *
     * @return 目标方ID
     */
    public String getTgtId() {
        return tgtId;
    }

    /**
     * <p>目标方ID</p>
     *
     * @param tgtId 目标方ID
     */
    public void setTgtId(String tgtId) {
        this.tgtId = tgtId;
    }
    /**
     * <p>目标方编码</p>
     *
     * @return 目标方编码
     */
    public String getTgtCode() {
        return tgtCode;
    }

    /**
     * <p>目标方编码</p>
     *
     * @param tgtCode 目标方编码
     */
    public void setTgtCode(String tgtCode) {
        this.tgtCode = tgtCode;
    }
    /**
     * <p>目标方类型，Master数据</p>
     *
     * @return 目标方类型，Master数据
     */
    public String getTgtType() {
        return tgtType;
    }

    /**
     * <p>目标方类型，Master数据</p>
     *
     * @param tgtType 目标方类型，Master数据
     */
    public void setTgtType(String tgtType) {
        this.tgtType = tgtType;
    }

}
