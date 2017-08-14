package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;

public class BuyerReturnDetailEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 退货明细ID [退货明细ID]
     */
    private Long detailId;

    /**
     * 获取退货明细ID [退货明细ID]
     *
     * @return 退货明细ID [退货明细ID]
     */
    public Long getDetailId() {
        return this.detailId;
    }

    /**
     * 设置退货明细ID [退货明细ID]
     *
     * @param detailId
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * 退货单ID [退货单ID]
     */
    private Long returnId;

    /**
     * 获取退货单ID [退货单ID]
     *
     * @return 退货单ID [退货单ID]
     */
    public Long getReturnId() {
        return this.returnId;
    }

    /**
     * 设置退货单ID [退货单ID]
     *
     * @param returnId
     */
    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    /**
     * 配送明细ID [配送明细ID]
     */
    private Long distributionNotificationDetailId;

    /**
     * 获取配送明细ID [配送明细ID]
     *
     * @return 配送明细ID [配送明细ID]
     */
    public Long getDistributionNotificationDetailId() {
        return this.distributionNotificationDetailId;
    }

    /**
     * 设置配送明细ID [配送明细ID]
     *
     * @param distributionNotificationDetailId
     */
    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    /**
     * 收货单ID
     */
    private Long receiveNotificationId;

    /**
     * 获取收货单ID
     *
     * @return 收货单ID
     */
    public Long getReceiveNotificationId() {
        return this.receiveNotificationId;
    }

    /**
     * 设置收货单ID
     *
     * @param receiveNotificationId
     */
    public void setReceiveNotificationId(Long receiveNotificationId) {
        this.receiveNotificationId = receiveNotificationId;
    }

    /**
     * 收货单明细ID
     */
    private Long receiveNotificationDetailId;

    /**
     * 获取收货单明细ID
     *
     * @return 收货单明细ID
     */
    public Long getReceiveNotificationDetailId() {
        return this.receiveNotificationDetailId;
    }

    /**
     * 设置收货单明细ID
     *
     * @param receiveNotificationDetailId
     */
    public void setReceiveNotificationDetailId(Long receiveNotificationDetailId) {
        this.receiveNotificationDetailId = receiveNotificationDetailId;
    }

    /**
     * 商品ID [商品ID]
     */
    private String goodsId;

    /**
     * 获取商品ID [商品ID]
     *
     * @return 商品ID [商品ID]
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品ID [商品ID]
     *
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 销售单位 [销售单位]
     */
    private String salesUnit;

    /**
     * 获取销售单位 [销售单位]
     *
     * @return 销售单位 [销售单位]
     */
    public String getSalesUnit() {
        return this.salesUnit;
    }

    /**
     * 设置销售单位 [销售单位]
     *
     * @param salesUnit
     */
    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    /**
     * 退货数量 [退货数量]
     */
    private BigDecimal returnQty;

    /**
     * 获取退货数量 [退货数量]
     *
     * @return 退货数量 [退货数量]
     */
    public BigDecimal getReturnQty() {
        return this.returnQty;
    }

    /**
     * 设置退货数量 [退货数量]
     *
     * @param returnQty
     */
    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    /**
     * 退货原因ID [退货原因ID]
     */
    private Long reasonId;

    /**
     * 获取退货原因ID [退货原因ID]
     *
     * @return 退货原因ID [退货原因ID]
     */
    public Long getReasonId() {
        return this.reasonId;
    }

    /**
     * 设置退货原因ID [退货原因ID]
     *
     * @param reasonId
     */
    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    /**
     * 退货入库批次 [退货入库批次]
     */
    private String inboundBatch;

    /**
     * 获取退货入库批次 [退货入库批次]
     *
     * @return 退货入库批次 [退货入库批次]
     */
    public String getInboundBatch() {
        return this.inboundBatch;
    }

    /**
     * 设置退货入库批次 [退货入库批次]
     *
     * @param inboundBatch
     */
    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }

    /**
     * 配送单ID [配送单ID]
     */
    private Long distributionNotificationId;

    /**
     * 获取配送单ID [配送单ID]
     *
     * @return 配送单ID [配送单ID]
     */
    public Long getDistributionNotificationId() {
        return this.distributionNotificationId;
    }

    /**
     * 设置配送单ID [配送单ID]
     *
     * @param distributionNotificationId
     */
    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    /**
     * 退货入库数量 [退货入库数量]
     */
    private BigDecimal inboundQty;

    /**
     * 获取退货入库数量 [退货入库数量]
     *
     * @return 退货入库数量 [退货入库数量]
     */
    public BigDecimal getInboundQty() {
        return this.inboundQty;
    }

    /**
     * 设置退货入库数量 [退货入库数量]
     *
     * @param inboundQty
     */
    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }
}
