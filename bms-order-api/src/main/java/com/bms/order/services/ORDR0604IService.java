package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0604IBeanParam;

/**
 * 买手订单确认接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0604IService {
    /**
     * 订单系统/平台订单人员确认买手订单，占用库存，生成记账凭证
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0604IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0604IBeanParam bean);
}
