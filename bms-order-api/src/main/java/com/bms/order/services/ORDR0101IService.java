package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0101IBeanParam;

/**
 * 买家订单创建接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0101IService {
    /**
     * A类、B类的标准订单和分批订单创建
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0101IBeanParam
     */
    @Transactional
    public Long execute(Operator operator, ORDR0101IBeanParam bean);
}
