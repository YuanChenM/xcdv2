package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0605IFilterParam;
import com.bms.order.bean.result.ORDR0605IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;

/**
 * 买手订单查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0605IService extends BaseService {
    /**
     * 买手/冻品管家/平台订单人员查询自己权限可以访问的买手订单
     * 
     * @param operator
     *            操作者
     * @param param
     *            ORDR0605IRestParam
     */
    @Transactional
    public SearchRestResult<ORDR0605IL1RestResult> execute(Operator operator,
            SearchRestParam<ORDR0605IFilterParam> param);
}
