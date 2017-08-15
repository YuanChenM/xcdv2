package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0205IBeanParam;

/**
 * 订单手动分拆阈值设定接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0205IService {
    /**
     * 设定是否进行手动分拆
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0205IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0205IBeanParam bean);
}
