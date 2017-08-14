package com.bms.byim.services.impl;

import com.bms.byim.bean.param.BuyerAllRsParam;
import com.bms.byim.dao.ByimRegionCheckDao;
import com.bms.byim.services.ByimRegionCheckService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
@Service
public class ByimRegionCheckServiceImpl extends BaseServiceImpl implements ByimRegionCheckService{

    @Autowired
    private ByimRegionCheckDao byimRegionCheckDao;

    @Override
    public BaseDao getBaseDao() {
        return byimRegionCheckDao;
    }

    @Override
    public int checkRegionNum(BuyerAllRsParam param) {
        return byimRegionCheckDao.checkRegionNum(param);
    }

    @Override
    public int checkLgcsRegionNum(BuyerAllRsParam param) {
        return byimRegionCheckDao.checkLgcsRegionNum(param);
    }
}
