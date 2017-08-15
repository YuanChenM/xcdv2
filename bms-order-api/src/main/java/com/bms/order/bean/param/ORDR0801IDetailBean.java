package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.bms.order.common.rest.param.RestBean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/2.
 */
public class ORDR0801IDetailBean extends RestBean {

    private static final long serialVersionUID = 1L;

    /**
     * 	配送单ID
     */
    private Long distributionNotificationId;
    /**
     * 	配送通知单明细ID
     */
    private Long distributionNotificationDetailId;
    /**
     * 	收货通知单明细ID
     */
    private Long receiveNotificationDetailId;
    /**
     * 	商品ID
     */
    private String goodsId;
    /**
     * 	退货数量
     */
    private BigDecimal returnQty;
    private BigDecimal returnPriceUnit;
    /**
     * 退货明细退货原因
     */
    private Long detailReasonId;


    public Long getDistributionNotificationId() {
        return distributionNotificationId;
    }

    public void setDistributionNotificationId(Long distributionNotificationId) {
        this.distributionNotificationId = distributionNotificationId;
    }

    public Long getDistributionNotificationDetailId() {
        return distributionNotificationDetailId;
    }

    public void setDistributionNotificationDetailId(Long distributionNotificationDetailId) {
        this.distributionNotificationDetailId = distributionNotificationDetailId;
    }

    public Long getReceiveNotificationDetailId() {
        return receiveNotificationDetailId;
    }

    public void setReceiveNotificationDetailId(Long receiveNotificationDetailId) {
        this.receiveNotificationDetailId = receiveNotificationDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public Long getDetailReasonId() {
        return detailReasonId;
    }

    public void setDetailReasonId(Long detailReasonId) {
        this.detailReasonId = detailReasonId;
    }

    /**
     * 查询收获明细
     * @return
     */
    public ReceiveNotificationDetail findReceiveNotificationDetail(){
        ReceiveNotificationDetail receiveNotificationDetail = ReceiveNotificationDetail.
                build(null).forComplete(receiveNotificationDetailId);
        return receiveNotificationDetail;
    }

    /**
     * 创建退货明细
     * @return
     */
    public BuyerReturnDetail generateBuyerReturnDetail(){
        BuyerReturnDetailEntity entity = new BuyerReturnDetailEntity();
        entity.setDistributionNotificationId(distributionNotificationId);
        entity.setDistributionNotificationDetailId(distributionNotificationDetailId);
        entity.setReceiveNotificationDetailId(receiveNotificationDetailId);
        entity.setGoodsId(getGoodsId());
        entity.setReturnQty(returnQty);
        entity.setReasonId(detailReasonId);
        BuyerReturnDetail buyerReturnDetail = BuyerReturnDetail.build(null).forCreate(entity);
        return buyerReturnDetail;
    }

    public ReturnReason detailFindReturnReason(){
        if(null == detailReasonId){
            return null;
        }
        ReturnReason returnReason = ReturnReason.build(null).forComplete(detailReasonId);
        return returnReason;
    }

    public BigDecimal getReturnPriceUnit() {
        return returnPriceUnit;
    }

    public void setReturnPriceUnit(BigDecimal returnPriceUnit) {
        this.returnPriceUnit = returnPriceUnit;
    }
}
