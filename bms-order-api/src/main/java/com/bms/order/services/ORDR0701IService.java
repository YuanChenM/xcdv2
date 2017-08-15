package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0701IBeanParam;

/**
 * 支付通知回传接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0701IService {
    /**
     * 资金结算系统发送支付信息，通知订单系统进行系统内支付
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0701IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0701IBeanParam bean);
}
