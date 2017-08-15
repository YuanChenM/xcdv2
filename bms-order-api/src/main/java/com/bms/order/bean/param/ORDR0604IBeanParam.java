package com.bms.order.bean.param;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.common.rest.param.RestBean;

/**
 * 买手订单确认接口Param
 *
 * @author li_huiqian
 */
public class ORDR0604IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = -6677980636482665982L;
    private Long bsOrderId;

    public Long getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    public BsOrder generateBsOrder() {
        BsOrder bsOrder = BsOrder.build(null).forComplete(bsOrderId);
        return bsOrder;
    }
}
