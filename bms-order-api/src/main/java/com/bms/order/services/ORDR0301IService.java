package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0301IBeanParam;

/**
 * 配送通知单创建接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0301IService {
    /**
     * 订单系统根据期望配送日期对已分单的分批订单生成配送通知单，并发送给WMS系统
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0301IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0301IBeanParam bean);
}
