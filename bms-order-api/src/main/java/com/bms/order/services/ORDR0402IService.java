package com.bms.order.services;

import com.bms.order.common.rest.BaseSearchRestParam;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0402IFilterParam;
import com.bms.order.bean.result.ORDR0402IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;

/**
 * 订单信息及对应价盘查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0402IService {

    /**
     * 美迪福调用，获取最终的价盘通道
     * 
     * @param operator
     * @param param
     * @return
     */
    @Transactional
    ORDR0402IRestResult execute(Operator operator,ORDR0402IFilterParam param);
}
