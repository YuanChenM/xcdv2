package com.bms.byim.dao;

import com.bms.byim.bean.param.BuyerAllRsParam;
import com.framework.boot.base.BaseDao;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
public interface ByimRegionCheckDao extends BaseDao {

    int checkRegionNum(BuyerAllRsParam param);

    int checkLgcsRegionNum(BuyerAllRsParam param);
}