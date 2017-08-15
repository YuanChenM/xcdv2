package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0601IBeanParam;

/**
 * 买手订单创建接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0601IService {
    /**
     * 买手囤实物订单和买手囤货权订单创建
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0601IBeanParam
     */
    @Transactional
    public Long  execute(Operator operator, ORDR0601IBeanParam bean);
}
