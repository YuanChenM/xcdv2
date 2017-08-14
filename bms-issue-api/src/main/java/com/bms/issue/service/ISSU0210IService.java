package com.bms.issue.service;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0210IFilter;
import com.bms.issue.bean.result.ISSU0210IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/2/20.
 */
public interface ISSU0210IService extends BaseService {

    /**
     * 查询问题订单相关信息
     *
     * @param operator 操作者
     *
     * @param param ISSU0210IFilter
     *
     */
    @Transactional
    public SearchRestResult<ISSU0210IRestResult> execute(Operator operator, SearchRestParam<ISSU0210IFilter> param);

}

