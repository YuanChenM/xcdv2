package com.bms.order.services;

import com.bms.order.bean.param.ORDR0501IRestParam;
import com.bms.order.bean.result.ORDR0501IRestResult;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0501IBeanParam;

/**
 * 收货通知回传接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0501IService {
    /**
     * WMS系统发送收货通知单，通知订单系统进行系统内收货、拒收退货、迟收退货
     * 
     * @param operator
     *            操作者
     * @param beans
     *            ORDR0501IRestParam
     */
    @Transactional
    ORDR0501IRestResult execute(Operator operator, ORDR0501IRestParam beans);
}
