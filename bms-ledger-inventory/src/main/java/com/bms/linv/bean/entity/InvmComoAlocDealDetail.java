/*
 * 2017/04/14 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.linv.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表invm_como_aloc_deal_detail对应的实体InvmComoAlocDealDetail</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class InvmComoAlocDealDetail extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 占用流水ID */
    private Long alDealId;
    /** 占用编号 */
    private String alocNo;
    /** 业务单ID */
    private Long transactionId;
    /** 业务单号 */
    private String transactionNo;
    /** 业务单明细ID */
    private Long transactionDetailId;
    /** 业务校验序列 */
    private Integer transactionSequence;
    /** 模块编号，例如订单模块编号 */
    private String transactionSource;
    /** 接口编号 */
    private String transactionType;
    /** 业务时间 */
    private java.util.Date transactionTime;
    /** 参考号 */
    private String refNo;
    /** 业务类型 */
    private String bizType;
    /** 占用交易单价（预留） */
    private java.math.BigDecimal alocPrice;
    /** 占用交易数量 */
    private java.math.BigDecimal alocQty;
    /** 目标方ID */
    private String tgtId;
    /** 目标方编码 */
    private String tgtCode;
    /** 目标方类型,Master数据 */
    private String tgtType;

    /**
     * <p>默认构造函数</p>
     */
    public InvmComoAlocDealDetail() {
    }

    /**
     * <p>占用流水ID</p>
     *
     * @return 占用流水ID
     */
    public Long getAlDealId() {
        return alDealId;
    }

    /**
     * <p>占用流水ID</p>
     *
     * @param alDealId 占用流水ID
     */
    public void setAlDealId(Long alDealId) {
        this.alDealId = alDealId;
    }
    /**
     * <p>占用编号</p>
     *
     * @return 占用编号
     */
    public String getAlocNo() {
        return alocNo;
    }

    /**
     * <p>占用编号</p>
     *
     * @param alocNo 占用编号
     */
    public void setAlocNo(String alocNo) {
        this.alocNo = alocNo;
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
     * <p>业务时间</p>
     *
     * @return 业务时间
     */
    public java.util.Date getTransactionTime() {
        return transactionTime;
    }

    /**
     * <p>业务时间</p>
     *
     * @param transactionTime 业务时间
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
     * <p>业务类型</p>
     *
     * @return 业务类型
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * <p>业务类型</p>
     *
     * @param bizType 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    /**
     * <p>占用交易单价（预留）</p>
     *
     * @return 占用交易单价（预留）
     */
    public java.math.BigDecimal getAlocPrice() {
        return alocPrice;
    }

    /**
     * <p>占用交易单价（预留）</p>
     *
     * @param alocPrice 占用交易单价（预留）
     */
    public void setAlocPrice(java.math.BigDecimal alocPrice) {
        this.alocPrice = alocPrice;
    }
    /**
     * <p>占用交易数量</p>
     *
     * @return 占用交易数量
     */
    public java.math.BigDecimal getAlocQty() {
        return alocQty;
    }

    /**
     * <p>占用交易数量</p>
     *
     * @param alocQty 占用交易数量
     */
    public void setAlocQty(java.math.BigDecimal alocQty) {
        this.alocQty = alocQty;
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
     * <p>目标方类型,Master数据</p>
     *
     * @return 目标方类型,Master数据
     */
    public String getTgtType() {
        return tgtType;
    }

    /**
     * <p>目标方类型,Master数据</p>
     *
     * @param tgtType 目标方类型,Master数据
     */
    public void setTgtType(String tgtType) {
        this.tgtType = tgtType;
    }

}
