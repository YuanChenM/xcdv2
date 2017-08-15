package com.bms.order.fms.services.impl;

import com.bms.order.fms.bean.OmsOrderPayment;
import com.bms.order.fms.dao.OmsOrderPaymentDao;
import com.bms.order.fms.services.OmsOrderPaymentService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuan_chen on 2017/5/6
 *
 * OMS买家订单溯源services
 */
@Service
public class OmsOrderPaymentServiceImpl extends BaseServiceImpl implements OmsOrderPaymentService {

    @Autowired
    private OmsOrderPaymentDao omsOrderPaymentDao;

    @Override
    public BaseDao getBaseDao() {
        return omsOrderPaymentDao;
    }

    /**
     * 设置买家第一次支付款
     */
    public List<OmsOrderPayment> getOrderPayment(Long orderId){
        OmsOrderPayment orderPayment = new OmsOrderPayment();
        orderPayment.setOrderId(orderId);
        return omsOrderPaymentDao.findOrderPayment(orderPayment);
    }

    /**
     * 设置订单全部付款金额
     */
    public List<OmsOrderPayment> getOrderTotalPayment(Long orderId){
        OmsOrderPayment orderPayment = new OmsOrderPayment();
        orderPayment.setOrderId(orderId);
        return omsOrderPaymentDao.findOrderTotalPayment(orderPayment);
    }
}

