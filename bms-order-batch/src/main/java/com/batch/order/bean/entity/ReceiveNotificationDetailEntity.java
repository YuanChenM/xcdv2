package com.batch.order.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class ReceiveNotificationDetailEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /** 收货明细：收货通知单明细ID */
    private Long receiveNotificationDetailId;

    /**
     * 获取收货明细：收货通知单明细ID
     * 
     * @return 收货明细：收货通知单明细ID
     */
    public Long getReceiveNotificationDetailId() {
        return this.receiveNotificationDetailId;
    }

    /**
     * 设置收货明细：收货通知单明细ID
     * 
     * @param receiveNotificationDetailId
     */
    public void setReceiveNotificationDetailId(Long receiveNotificationDetailId) {
        this.receiveNotificationDetailId = receiveNotificationDetailId;
    }

    /** 收货明细：收货通知单ID */
    private Long receiveNotificationId;

    /**
     * 获取收货明细：收货通知单ID
     * 
     * @return 收货明细：收货通知单ID
     */
    public Long getReceiveNotificationId() {
        return this.receiveNotificationId;
    }

    /**
     * 设置收货明细：收货通知单ID
     * 
     * @param receiveNotificationId
     */
    public void setReceiveNotificationId(Long receiveNotificationId) {
        this.receiveNotificationId = receiveNotificationId;
    }

    /** 明细：配送明细ID */
    private Long distributionNotificationDetailId;

    /**
     * 获取明细：配送明细ID
     * 
     * @return 明细：配送明细ID
     */
    public Long getDistributionNotificationDetailId() {
        return this.distributionNotificationDetailId;
    }

    /**
     * 设置明细：配送明细ID
     * 
     * @param distributionNotificationDetailId
     */
    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    /** 商品：商品ID */
    private String goodsId;

    /**
     * 获取商品：商品ID
     * 
     * @return 商品：商品ID
     */
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置商品：商品ID
     * 
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /** 商品：商品SKU [【精确到生产商和卖家的SKU】] */
    private String sku;

    /**
     * 获取商品：商品SKU [【精确到生产商和卖家的SKU】]
     * 
     * @return 商品：商品SKU [【精确到生产商和卖家的SKU】]
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置商品：商品SKU [【精确到生产商和卖家的SKU】]
     * 
     * @param sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /** 商品：批次 [【产品处无批次】] */
    private String batch;

    /**
     * 获取商品：批次 [【产品处无批次】]
     * 
     * @return 商品：批次 [【产品处无批次】]
     */
    public String getBatch() {
        return this.batch;
    }

    /**
     * 设置商品：批次 [【产品处无批次】]
     * 
     * @param batch
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /** 收货明细：收货数量 */
    private BigDecimal receiveQuantity;

    /**
     * 获取收货明细：收货数量
     * 
     * @return 收货明细：收货数量
     */
    public BigDecimal getReceiveQuantity() {
        return this.receiveQuantity;
    }

    /**
     * 设置收货明细：收货数量
     * 
     * @param receiveQuantity
     */
    public void setReceiveQuantity(BigDecimal receiveQuantity) {
        this.receiveQuantity = receiveQuantity;
    }

    /** 收货明细：拒收退货数量 */
    private BigDecimal rejectQuantity;

    /**
     * 获取收货明细：拒收退货数量
     * 
     * @return 收货明细：拒收退货数量
     */
    public BigDecimal getRejectQuantity() {
        return this.rejectQuantity;
    }

    /**
     * 设置收货明细：拒收退货数量
     * 
     * @param rejectQuantity
     */
    public void setRejectQuantity(BigDecimal rejectQuantity) {
        this.rejectQuantity = rejectQuantity;
    }

    /** 收货明细：迟收退货数量 */
    private BigDecimal delayQuantity;

    /**
     * 获取收货明细：迟收退货数量
     * 
     * @return 收货明细：迟收退货数量
     */
    public BigDecimal getDelayQuantity() {
        return this.delayQuantity;
    }

    /**
     * 设置收货明细：迟收退货数量
     * 
     * @param delayQuantity
     */
    public void setDelayQuantity(BigDecimal delayQuantity) {
        this.delayQuantity = delayQuantity;
    }

    /** 迟收：迟收再配送日 */
    private Date redistributionDate;

    /**
     * 获取迟收：迟收再配送日
     * 
     * @return 迟收：迟收再配送日
     */
    public Date getRedistributionDate() {
        return this.redistributionDate;
    }

    /**
     * 设置迟收：迟收再配送日
     * 
     * @param redistributionDate
     */
    public void setRedistributionDate(Date redistributionDate) {
        this.redistributionDate = redistributionDate;
    }

    /** 收货明细：退货数量 */
    private BigDecimal returnQuantity;

    /**
     * 获取收货明细：退货数量
     * 
     * @return 收货明细：退货数量
     */
    public BigDecimal getReturnQuantity() {
        return this.returnQuantity;
    }

    /**
     * 设置收货明细：退货数量
     * 
     * @param returnQuantity
     */
    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    /** 价盘：单价 */
    private BigDecimal pricePlateUnitPrice;

    /**
     * 获取价盘：单价
     * 
     * @return 价盘：单价
     */
    public BigDecimal getPricePlateUnitPrice() {
        return this.pricePlateUnitPrice;
    }

    /**
     * 设置价盘：单价
     * 
     * @param pricePlateUnitPrice
     */
    public void setPricePlateUnitPrice(BigDecimal pricePlateUnitPrice) {
        this.pricePlateUnitPrice = pricePlateUnitPrice;
    }
}
