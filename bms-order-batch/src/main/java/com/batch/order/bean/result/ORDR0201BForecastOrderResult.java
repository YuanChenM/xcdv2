package com.batch.order.bean.result;

import com.batch.order.bean.entity.BuyerForcastDeliverDetailAttachedEntity;
import com.batch.order.bean.entity.BuyerForcastDeliverDetailEntity;

import java.io.Serializable;

/**
 * Created by liutao on 2017/1/10.
 */
public class ORDR0201BForecastOrderResult implements Serializable {
    private BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity;

    private BuyerForcastDeliverDetailAttachedEntity buyerForcastDeliverDetailAttachedEntity;

    public BuyerForcastDeliverDetailEntity getBuyerForcastDeliverDetailEntity() {
        return buyerForcastDeliverDetailEntity;
    }

    public void setBuyerForcastDeliverDetailEntity(BuyerForcastDeliverDetailEntity buyerForcastDeliverDetailEntity) {
        this.buyerForcastDeliverDetailEntity = buyerForcastDeliverDetailEntity;
    }

    public BuyerForcastDeliverDetailAttachedEntity getBuyerForcastDeliverDetailAttachedEntity() {
        return buyerForcastDeliverDetailAttachedEntity;
    }

    public void setBuyerForcastDeliverDetailAttachedEntity(BuyerForcastDeliverDetailAttachedEntity buyerForcastDeliverDetailAttachedEntity) {
        this.buyerForcastDeliverDetailAttachedEntity = buyerForcastDeliverDetailAttachedEntity;
    }
}
