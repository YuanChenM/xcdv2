package com.bms.order.fms.services;

import com.bms.order.fms.bean.OmsOrderPayment;
import com.framework.boot.base.BaseService;

import java.util.List;

/**
 * Created by yuan_chen on 2017/5/6
 *
 * OMS买家订单溯源services
 */
public interface OmsOrderPaymentService extends BaseService {
    List<OmsOrderPayment> getOrderPayment(Long param);
    List<OmsOrderPayment> getOrderTotalPayment(Long param);
}
