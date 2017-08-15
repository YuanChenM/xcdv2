package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0807IFilter;
import com.bms.order.bean.result.ORDR0807IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
public interface ORDR0807IDao extends BaseDao {
    public List<ORDR0807IRestResult> findReturnInfo(SearchRestParam<ORDR0807IFilter> param);
    public int getCount(SearchRestParam<ORDR0807IFilter> param);
}
