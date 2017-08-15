package com.bms.order.bean.result;

import com.bms.order.common.rest.result.RestSearchData;

import java.util.List;

/**
 * 订单信息及对应价盘查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR0402IRestResult extends RestSearchData {
    private static final long serialVersionUID = 1L;

    private List<ORDR0402IOrderResult> orderList;

    public List<ORDR0402IOrderResult> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ORDR0402IOrderResult> orderList) {
        this.orderList = orderList;
    }
}
