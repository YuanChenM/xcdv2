package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0105IFilterParam;
import com.bms.order.bean.result.ORDR0105IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by ni_shaotang on 2016/12/30.
 */
public interface ORDR0105IDao extends BaseDao {
    public int getCount(SearchRestParam<ORDR0105IFilterParam> param);
    public List<ORDR0105IL1RestResult> findOrdersInfo(SearchRestParam<ORDR0105IFilterParam> param);
}
