package com.bms.order.services;

import org.springframework.transaction.annotation.Transactional;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0303IFilterParam;
import com.bms.order.bean.result.ORDR0303IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;

/**
 * 配送通知单查询接口Service
 * 
 * @author li_huiqian
 */
public interface ORDR0303IService extends BaseService {
    /**
     * 平台订单人员查询自己权限可以访问的配送通知单
     * 
     * @param operator
     *            操作者
     * @param param
     *            ORDR0303IBeanParam
     */
    @Transactional
    public SearchRestResult<ORDR0303IL1RestResult> execute(Operator operator,
            SearchRestParam<ORDR0303IFilterParam> param);
}
