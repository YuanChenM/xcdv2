package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0602IBeanParam;

/**
 * 买手订单修改接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0602IService {
    /**
     * 买手囤货完成前，对订单基本信息进行修改
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0602IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0602IBeanParam bean, int step);
}
