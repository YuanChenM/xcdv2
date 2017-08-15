package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerBatchOrder;
import com.bms.order.common.rest.param.RestBean;

/**
 * 订单分拆结果确认接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0203IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -7354825800479007499L;

    /**
     * 买家分批订单ID
     */
    private Long batchOrderId;

    public Long getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(Long batchOrderId) {
        this.batchOrderId = batchOrderId;
    }

    public BuyerBatchOrder generateBuyerBatchOrder() {
        BuyerBatchOrder buyerBatchOrder = BuyerBatchOrder.build(null).forComplete(batchOrderId);
        return buyerBatchOrder;
    }

}
