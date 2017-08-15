package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0502IFilterParam;
import com.bms.order.bean.result.ORDR0502IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by wang_jianzhou on 2017/1/18.
 */
public interface ORDR0502IDao extends BaseDao {
    public int getTotalCount(SearchRestParam<ORDR0502IFilterParam> param);
    public List<ORDR0502IRestResult> findPageInfos(SearchRestParam<ORDR0502IFilterParam> param);
}
