package com.bms.order.bean.param;

import java.math.BigDecimal;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.common.rest.param.RestBean;
import com.bms.order.util.BeanUtils;

/**
 * Created by ni_shaotang on 2017/1/9.
 */
public class ORDR0102IProductBean extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -8279093051468491003L;
    /** 买家分批订单明细ID */
    private Long buyerBatchOrderDetailId;
    /** 商品ID */
    private String goodsId;
    /** 商品数量 */
    private BigDecimal goodsQuantity;
    /** 版本号 */
    private Integer ver;

    public Long getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public BuyerBatchOrderDetail getBuyerBatchDetail() {
        BuyerBatchOrderDetailEntity batchOrderDetailEntity = new BuyerBatchOrderDetailEntity();
        BeanUtils.copyProperties(this, batchOrderDetailEntity);
        BuyerBatchOrderDetailAttachedEntity attachedEntity = new BuyerBatchOrderDetailAttachedEntity();
        BeanUtils.copyProperties(this, attachedEntity);
        BuyerBatchOrderDetail batchOrderDetail = new BuyerBatchOrderDetail(batchOrderDetailEntity, attachedEntity);
        return batchOrderDetail;
    }

    public BuyerBatchOrderDetail modifiedBuyerBatchOrderDetail(BuyerOrder buyerOrder, BuyerBatchOrder buyerBatchOrder) {
        BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
        BuyerBatchOrderDetailAttachedEntity attachedEntity = new BuyerBatchOrderDetailAttachedEntity();
        entity.setBuyerBatchOrderDetailId(buyerBatchOrderDetailId);
        attachedEntity.setBuyerBatchOrderDetailId(buyerBatchOrderDetailId);
        entity.setBuyerOrderId(buyerOrder.getEntity().getBuyerOrderId());
        entity.setBuyerBatchOrderId(buyerBatchOrder.getEntity().getBuyerBatchOrderId());
        entity.setGoodsQuantity(goodsQuantity);
        entity.setGoodsId(goodsId);
        entity.setVersion(ver);
        attachedEntity.setVersion(ver);
        BuyerBatchOrderDetail batchOrderDetail = BuyerBatchOrderDetail.build(null).forCreate(entity, attachedEntity);
        buyerOrder.link(batchOrderDetail);
        buyerBatchOrder.link(batchOrderDetail);
        return batchOrderDetail;
    }
}
