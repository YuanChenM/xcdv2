package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0606IBeanParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 买手订单创建接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0606IService {
    /**
     * 买手囤实物订单和买手囤货权订单创建
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0606IBeanParam
     */
    @Transactional
    public Long  execute(Operator operator, ORDR0606IBeanParam bean);
}
