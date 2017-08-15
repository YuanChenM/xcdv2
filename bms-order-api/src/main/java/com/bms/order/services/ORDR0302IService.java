package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0302IBeanParam;

/**
 * 配送通知单取消接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0302IService {
    /**
     * 平台订单人员对未交付的配送单进行取消发货操作
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0302IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0302IBeanParam bean);
}
