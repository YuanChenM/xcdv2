package com.bms.bymt.services.impl;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.bms.bymt.dao.BymtRegionCheckDao;
import com.bms.bymt.services.BymtRegionCheckService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guan_zhongheng on 2017/4/13.
 */
@Service
public class BymtRegionCheckServiceImpl extends BaseServiceImpl implements BymtRegionCheckService{

    @Autowired
    private BymtRegionCheckDao bymtRegionCheckDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtRegionCheckDao;
    }


    @Override
    public int checkRegionNum(MarketFoodModuleBasicRsParam param) {
        return bymtRegionCheckDao.checkRegionNum(param);
    }
}
