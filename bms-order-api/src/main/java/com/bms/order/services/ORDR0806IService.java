package com.bms.order.services;

import com.bms.order.common.rest.BaseSearchRestParam;
import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0806IFilter;
import com.bms.order.bean.result.ORDR0806IRestResult;
import com.bms.order.common.rest.SearchRestResult;

/**
 * 买家退货原因查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0806IService {
    /**
     * 买家退货原因查询接口,分Json版和Xml版
     * 
     * @param operator
     *            操作者
     * @param param ORDR0806IBean
     *
     */
    @Transactional
    public SearchRestResult<ORDR0806IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0806IFilter> param);
}
