package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.bean.result.ORDR0904IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;

/**
 * 买手退货信息查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0904IService {
    /**
     * 查询买手退货相关信息
     * 
     * @param operator
     *            操作者
     * @param param ORDR0904IBean
     *
     */
    @Transactional
    public SearchRestResult<ORDR0904IRestResult> execute(Operator operator, SearchRestParam<ORDR0904IFilter> param);
}
