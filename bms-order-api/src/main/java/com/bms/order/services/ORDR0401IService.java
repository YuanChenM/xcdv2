package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0401IBeanParam;

/**
 * 发货通知回传接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0401IService {
    /**
     * WMS系统发送发货通知单，通知订单系统进行系统内发货
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0401IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0401IBeanParam bean);
}
