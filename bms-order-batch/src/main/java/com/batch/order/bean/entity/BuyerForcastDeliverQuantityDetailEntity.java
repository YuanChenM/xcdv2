package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyerForcastDeliverQuantityDetailEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 预配送明细数量ID
     */
    private Long buyerForcastDeliverQuantityDetailId;

    /**
     * 获取预配送明细数量ID
     *
     * @return 预配送明细数量ID
     */
    public Long getBuyerForcastDeliverQuantityDetailId() {
        return this.buyerForcastDeliverQuantityDetailId;
    }

    /**
     * 设置预配送明细数量ID
     *
     * @param buyerForcastDeliverQuantityDetailId
     */
    public void setBuyerForcastDeliverQuantityDetailId(Long buyerForcastDeliverQuantityDetailId) {
        this.buyerForcastDeliverQuantityDetailId = buyerForcastDeliverQuantityDetailId;
    }

    /**
     * 预配送明细ID
     */
    private Long buyerForcastDeliverDetailId;

    /**
     * 获取预配送明细ID
     *
     * @return 预配送明细ID
     */
    public Long getBuyerForcastDeliverDetailId() {
        return this.buyerForcastDeliverDetailId;
    }

    /**
     * 设置预配送明细ID
     *
     * @param buyerForcastDeliverDetailId
     */
    public void setBuyerForcastDeliverDetailId(Long buyerForcastDeliverDetailId) {
        this.buyerForcastDeliverDetailId = buyerForcastDeliverDetailId;
    }

    /**
     * 配送：应该发货数量
     */
    private BigDecimal planSendQuantity;

    /**
     * 获取配送：应该发货数量
     *
     * @return 配送：应该发货数量
     */
    public BigDecimal getPlanSendQuantity() {
        return this.planSendQuantity;
    }

    /**
     * 设置配送：应该发货数量
     *
     * @param planSendQuantity
     */
    public void setPlanSendQuantity(BigDecimal planSendQuantity) {
        this.planSendQuantity = planSendQuantity;
    }

    /**
     * 配送：实际发货数量
     */
    private BigDecimal realSendQuantity;

    /**
     * 获取配送：实际发货数量
     *
     * @return 配送：实际发货数量
     */
    public BigDecimal getRealSendQuantity() {
        return this.realSendQuantity;
    }

    /**
     * 设置配送：实际发货数量
     *
     * @param realSendQuantity
     */
    public void setRealSendQuantity(BigDecimal realSendQuantity) {
        this.realSendQuantity = realSendQuantity;
    }

    /**
     * 配送：收货数量
     */
    private BigDecimal receiveQuantity;

    /**
     * 获取配送：收货数量
     *
     * @return 配送：收货数量
     */
    public BigDecimal getReceiveQuantity() {
        return this.receiveQuantity;
    }

    /**
     * 设置配送：收货数量
     *
     * @param receiveQuantity
     */
    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    /**
     * 配送：拒收退货数量
     */
    private BigDecimal rejectQuantity;

    /**
     * 获取配送：拒收退货数量
     *
     * @return 配送：拒收退货数量
     */
    public BigDecimal getRejectQuantity() {
        return this.rejectQuantity;
    }

    /**
     * 设置配送：拒收退货数量
     *
     * @param rejectQuantity
     */
    public void setRejectQuantity(BigDecimal rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    /**
     * 配送：迟收退货数量
     */
    private BigDecimal delayQuantity;

    /**
     * 获取配送：迟收退货数量
     *
     * @return 配送：迟收退货数量
     */
    public BigDecimal getDelayQuantity() {
        return this.delayQuantity;
    }

    /**
     * 设置配送：迟收退货数量
     *
     * @param delayQuantity
     */
    public void setDelayQuantity(BigDecimal delayQuantity) {
        this.delayQuantity = delayQuantity;
    }

    /**
     * 配送：再配送日
     */
    private Date redistributionDate;

    /**
     * 获取配送：再配送日
     *
     * @return 配送：再配送日
     */
    public Date getRedistributionDate() {
        return this.redistributionDate;
    }

    /**
     * 设置配送：再配送日
     *
     * @param redistributionDate
     */
    public void setRedistributionDate(Date redistributionDate) {
        this.redistributionDate = redistributionDate;
    }

    /**
     * 售后：退货数量
     */
    private BigDecimal returnQuantity;

    /**
     * 获取售后：退货数量
     *
     * @return 售后：退货数量
     */
    public BigDecimal getReturnQuantity() {
        return this.returnQuantity;
    }

    /**
     * 设置售后：退货数量
     *
     * @param returnQuantity
     */
    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }
}
