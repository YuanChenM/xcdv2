package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0105IFilterParam;
import com.bms.order.bean.result.ORDR0105IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;

/**
 * 买家订单查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0105IService extends BaseService {

    /**
     * 买家/平台订单人员/管家/买手查询自己权限可以访问的订单
     * 
     * @param operator
     * @param param
     * @return
     */
    @Transactional
    public SearchRestResult<ORDR0105IL1RestResult> execute(Operator operator,
            SearchRestParam<ORDR0105IFilterParam> param);
}
