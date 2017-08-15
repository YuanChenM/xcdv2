package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0102IBean;

/**
 * 买家订单修改接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0102IService {

    /**
     * 订单配送通知单发送给美迪福之前，对订单基本信息进行修改
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0102IBeanParam
     */
    @Transactional
    public void execute(Operator operator, ORDR0102IBean bean, int step);
}
