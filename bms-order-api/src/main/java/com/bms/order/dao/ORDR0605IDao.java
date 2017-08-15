package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0605IFilterParam;
import com.bms.order.bean.result.ORDR0605IL1RestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wu_honglei on 2017/1/9.
 */
public interface ORDR0605IDao extends BaseDao {
    public int getCount(SearchRestParam<ORDR0605IFilterParam> param);
    public List<ORDR0605IL1RestResult> findBsOrdersInfo(SearchRestParam<ORDR0605IFilterParam> param);
}
