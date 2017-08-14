package com.bms.bymt.dao;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.boot.base.BaseDao;

/**
 * Created by guan_zhongheng on 2017/4/13.
 */
public interface BymtRegionCheckDao extends BaseDao{

    int checkRegionNum(MarketFoodModuleBasicRsParam param);
}
