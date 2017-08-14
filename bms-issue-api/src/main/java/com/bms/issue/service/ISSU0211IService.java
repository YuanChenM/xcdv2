package com.bms.issue.service;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0211IFilter;
import com.bms.issue.bean.result.ISSU0211IRestResult;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/2/21.
 */
public interface ISSU0211IService extends BaseService {

    /**
     * 查询问题订单相关信息
     *
     * @param operator 操作者
     *
     * @param param ISSU0210IFilter
     *
     */
    @Transactional
    public SearchRestResult<ISSU0211IRestResult> execute(Operator operator, SearchRestParam<ISSU0211IFilter> param);

}
