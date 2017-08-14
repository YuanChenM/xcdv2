package com.bms.byim.services;

import com.bms.byim.bean.param.BuyerAllRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
public interface ByimRegionCheckService extends BaseService {

    @Transactional
    int checkRegionNum(BuyerAllRsParam param);
    @Transactional
    int checkLgcsRegionNum(BuyerAllRsParam param);
}
