package com.bms.order.services;

import com.bms.order.common.rest.BaseSearchRestParam;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0903IFilter;
import com.bms.order.bean.result.ORDR0903IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;

/**
 * 买手退货原因查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0903IService {
    /**
     * 买手退货原因查询接口
     * 
     * @param operator
     *            操作者
     * @param param ORDR0903IBean
     *
     */
    @Transactional
    public SearchRestResult<ORDR0903IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0903IFilter> param);
}
