package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0502IFilterParam;
import com.bms.order.bean.result.ORDR0502IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang_jianzhou on 2017/1/18.
 */
public interface ORDR0502IService extends BaseService {

    @Transactional
    public SearchRestResult<ORDR0502IRestResult> search(Operator operator,
                                                        SearchRestParam<ORDR0502IFilterParam> param);
}
