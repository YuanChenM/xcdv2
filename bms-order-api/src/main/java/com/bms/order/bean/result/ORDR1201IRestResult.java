package com.bms.order.bean.result;

import com.bms.order.bean.entity.HistoryOrderEntity;
import com.bms.order.common.rest.result.RestSearchData;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 历史订单查询接口Result
 *
 * @author li_huiqian
 */
public class ORDR1201IRestResult extends HistoryOrderEntity {
    private String orderTimeStr;

    public String getOrderTimeStr() {
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }
}
