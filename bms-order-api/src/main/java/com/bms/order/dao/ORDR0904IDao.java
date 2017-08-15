package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.bean.result.ORDR0904IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
public interface ORDR0904IDao extends BaseDao {

    public List<ORDR0904IRestResult> findReturnInfo(SearchRestParam<ORDR0904IFilter> param);

    public int getCount(SearchRestParam<ORDR0904IFilter> param);
}
