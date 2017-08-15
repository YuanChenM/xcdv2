package com.bms.order.bean.param;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.bean.entity.BuyerBatchOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;
import com.bms.order.common.rest.param.RestBean;

/**
 * 订单手动分拆阈值设定接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0205IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -6953618269855085299L;
    /** 买家分批订单明细ID */
    private Long buyerBatchOrderDetailId;
    /** 是否手动分拆 */
    private Boolean manualSplitFlg;

    public Long getBuyerBatchOrderDetailId() {
        return buyerBatchOrderDetailId;
    }

    public void setBuyerBatchOrderDetailId(Long buyerBatchOrderDetailId) {
        this.buyerBatchOrderDetailId = buyerBatchOrderDetailId;
    }

    public Boolean getManualSplitFlg() {
        return manualSplitFlg;
    }

    public void setManualSplitFlg(Boolean manualSplitFlg) {
        this.manualSplitFlg = manualSplitFlg;
    }

    public BuyerBatchOrderDetail generateBuyerBatchOrderDetail() {
        BuyerBatchOrderDetail buyerBatchOrderDetail = new BuyerBatchOrderDetail(buyerBatchOrderDetailId);
        return buyerBatchOrderDetail;
    }

    public BuyerBatchOrderDetail modified() {
        BuyerBatchOrderDetailEntity entity = new BuyerBatchOrderDetailEntity();
        BuyerBatchOrderDetailAttachedEntity attachedEntity = new BuyerBatchOrderDetailAttachedEntity();

        entity.setManualSplitFlg(manualSplitFlg);

        BuyerBatchOrderDetail buyerBatchOrderDetail = new BuyerBatchOrderDetail(entity, attachedEntity);
        return buyerBatchOrderDetail;
    }
}
