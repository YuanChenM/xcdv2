package com.bms.order.bean.param;

import com.bms.order.common.rest.param.RestBean;
import com.bms.order.common.rest.param.RestFilter;

import java.util.Date;

/**
 * 买手囤货接口Param
 * 
 * @author li_huiqian
 */
public class ORDR0607IFilterParam extends RestBean {
    /**
     * 买手订单ID
     */
    private Long bsOrderId;

    public Long getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }
}
