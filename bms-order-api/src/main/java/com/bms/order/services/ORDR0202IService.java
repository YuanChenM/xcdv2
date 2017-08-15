package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0202IBeanParam;

/**
 * 订单分拆结果取消接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0202IService {
    /**
     * 平台订单人员取消订单分拆结果
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0202IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0202IBeanParam bean);
}
