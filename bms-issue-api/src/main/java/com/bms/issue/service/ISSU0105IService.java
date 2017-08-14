package com.bms.issue.service;

import org.springframework.transaction.annotation.Transactional;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0105IFilter;
import com.bms.issue.bean.result.ISSU0105IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;

/**
 * 问题订单查询接口Service
 * 
 * @author li_huiqian
 */
public interface ISSU0105IService extends BaseService {
    /**
     * 查询问题订单相关信息
     * 
     * @param operator
     *            操作者
     * @param param ISSU0105IBean
     *
     */
    @Transactional
    public SearchRestResult<ISSU0105IRestResult> execute(Operator operator, SearchRestParam<ISSU0105IFilter> param);
}
