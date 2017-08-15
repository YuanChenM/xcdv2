package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0807IFilter;
import com.bms.order.bean.result.ORDR0807IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;

/**
 * 买家退货信息查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0807IService {
    /**
     * 查询买家退货相关信息
     * 
     * @param operator
     *            操作者
     * @param bean
     *            ORDR0807IBean
     */
    @Transactional
    public SearchRestResult<ORDR0807IRestResult> execute(Operator operator, SearchRestParam<ORDR0807IFilter> param);
}
