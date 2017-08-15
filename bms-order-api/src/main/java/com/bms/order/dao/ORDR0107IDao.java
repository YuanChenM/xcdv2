package com.bms.order.dao;

import com.bms.order.bean.param.ORDR0107IFilterParam;
import com.bms.order.bean.result.ORDR0107IRestResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by ni_shaotang on 2017/3/29.
 */
public interface ORDR0107IDao extends BaseDao {
    //查询所有下单数量
    public List<ORDR0107IRestResult> findAllSalesVolumes(ORDR0107IFilterParam param);

    //查询实际销售数量
    public List<ORDR0107IRestResult> findSalesVolumes(ORDR0107IFilterParam param);

}
