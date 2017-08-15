package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0603IBeanParam;

/**
 * 买手订单取消接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0603IService {
    /**
     * 囤货完成前，买手订单整单取消
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0603IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0603IBeanParam bean);
}
