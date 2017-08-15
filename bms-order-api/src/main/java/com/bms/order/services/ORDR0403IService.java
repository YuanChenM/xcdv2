package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0403IFilterParam;
import com.bms.order.bean.result.ORDR0403IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public interface ORDR0403IService extends BaseService {

    @Transactional
    public SearchRestResult<ORDR0403IRestResult> search(Operator operator,
                                                         SearchRestParam<ORDR0403IFilterParam> param);
}
