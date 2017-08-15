package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.common.rest.param.RestBean;

/**
 * 买家订单确认接口Param
 * 
 * @author li_huiqian
 */
public class ORDR1001IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 6133953647600490006L;
    /**
     * 买家订单Id
     */
    private Long buyerOrderId;

    public Long getBuyerOrderId() {
        return buyerOrderId;
    }

    public void setBuyerOrderId(Long buyerOrderId) {
        this.buyerOrderId = buyerOrderId;
    }

    /**
     * 获取buyerOrder 通过订单id
     * 
     * @return
     */
    public BuyerOrder getBuyerOrder() {
        return new BuyerOrder(this.buyerOrderId);
    }

    public BuyerOrder generateBuyerOrder(){

        BuyerOrder buyerOrder = BuyerOrder.build(null).forComplete(buyerOrderId);
        return buyerOrder;
    }
}
