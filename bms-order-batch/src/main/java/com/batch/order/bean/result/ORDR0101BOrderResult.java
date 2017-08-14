package com.batch.order.bean.result;

import com.batch.order.bean.entity.BuyerSellerDetailEntity;

/**
 * Created by liutao on 2017/1/5.
 */
public class ORDR0101BOrderResult extends BuyerSellerDetailEntity {

    private static final long serialVersionUID = 1L;

    private Long buyerOrderId;

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }
}
