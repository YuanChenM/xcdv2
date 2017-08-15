package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0107IFilterParam;
import com.bms.order.bean.result.ORDR0107IRestResult;
import com.bms.order.common.rest.BaseSearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ni_shaotang on 2017/3/29.
 */
public interface ORDR0107IService {
    /**
     * 商品销量查询接口
     * @param operator
     * @param param
     * @return
     */
    @Transactional
    public SearchRestResult<ORDR0107IRestResult> execute(Operator operator, BaseSearchRestParam<ORDR0107IFilterParam> param);
}
