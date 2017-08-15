package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0403IFilterParam;
import com.bms.order.bean.result.ORDR0403IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wang_jianzhou on 2017/1/17.
 */
public interface ORDR0403IDao extends BaseDao {
    public int getTotalCount(SearchRestParam<ORDR0403IFilterParam> param);
    public List<ORDR0403IRestResult> findPageInfos(SearchRestParam<ORDR0403IFilterParam> param);
}
