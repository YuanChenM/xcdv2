package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0203IBeanParam;

/**
 * 订单分拆结果确认接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0203IService {
    /**
     * 订单系统/平台订单人员对分拆待确认的订单分拆单进行确认
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0203IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0203IBeanParam bean);
}
