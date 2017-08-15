package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.common.rest.param.RestBean;

/**
 * 订单分拆结果取消接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0202IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 7086464840975024316L;

    /**
     * 买家分批订单详细ID
     */
    private Long buyerBatchOrderDetailId;

    /**
     * @return the buyerBatchOrderDetailId
     */
    public Long getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    /**
     * @param buyerBatchOrderDetailId
     *            the buyerBatchOrderDetailId to set
     */
    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public BuyerBatchOrderDetail generateBuyerBatchOrderDetail() {
        return BuyerBatchOrderDetail.build(null).forComplete(buyerBatchOrderDetailId);
    }

}
