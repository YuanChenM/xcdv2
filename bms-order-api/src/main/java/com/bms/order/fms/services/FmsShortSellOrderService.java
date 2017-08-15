package com.bms.order.fms.services;

import com.bms.order.fms.bean.FmsOrderParam;
import com.bms.order.fms.bean.FmsShortSellOrderBean;
import com.framework.boot.base.BaseService;

import java.util.List;

/**
 * Created by yuan_chen on 2017/4/27 0027.
 *
 * 买手合伙人囤货订单Service
 */
public interface FmsShortSellOrderService extends BaseService {
    List<FmsShortSellOrderBean> getShortSellOrder(FmsOrderParam param);
}
