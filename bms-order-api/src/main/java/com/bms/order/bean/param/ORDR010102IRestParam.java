package com.bms.order.bean.param;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;

/**
 * 买家订单创建接口(分批订单明细信息)Param
 * 
 * @author li_huiqian
 */
public class ORDR010102IRestParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1131957822692492724L;
    // 商品数量

    private BigDecimal goodsQuantity;
    // 商品ID
    private String goodsId;

    private BigDecimal priceUnit;

    private BigDecimal priceKg;

    private String wayDesc;

    public BuyerBatchOrderDetail generateBuyerBatchOrderDetail(BuyerOrder buyerOrder, BuyerBatchOrder buyerBatchOrder) {
        // 构建买家分批订单明细
        BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
        BuyerBatchOrderDetailAttachedEntity attachedEntity = new BuyerBatchOrderDetailAttachedEntity();

        entity.setGoodsQuantity(goodsQuantity);
        entity.setGoodsId(goodsId);
        entity.setPriceWay(wayDesc);
        entity.setOrderCreateKgPrice(priceKg);
        entity.setOrderCreateUnitPrice(priceUnit);
        entity.setRealKgPrice(priceKg);
        entity.setRealUnitPrice(priceUnit);
        BuyerBatchOrderDetail buyerBatchOrderDetail = BuyerBatchOrderDetail.build(null).forCreate(entity,
                attachedEntity);

        buyerBatchOrder.link(buyerBatchOrderDetail);
        buyerOrder.link(buyerBatchOrderDetail);
        return buyerBatchOrderDetail;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(BigDecimal priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal getPriceKg() {
        return priceKg;
    }

    public void setPriceKg(BigDecimal priceKg) {
        this.priceKg = priceKg;
    }

    public String getWayDesc() {
        return wayDesc;
    }

    public void setWayDesc(String wayDesc) {
        this.wayDesc = wayDesc;
    }
}
