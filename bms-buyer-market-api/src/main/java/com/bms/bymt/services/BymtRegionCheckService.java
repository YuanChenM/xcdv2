package com.bms.bymt.services;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/4/13.
 */
public interface BymtRegionCheckService extends BaseService{

    @Transactional
    int checkRegionNum(MarketFoodModuleBasicRsParam param);
}
