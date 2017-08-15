package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0305IBeanParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 配送通知单修改接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0305IService {
    /**
     * 配送通知单修改
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0305IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0305IBeanParam bean);
}
