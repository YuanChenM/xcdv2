package com.bms.agif.service.impl;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.AgentParam;
import com.bms.agif.dao.AgifRegionCheckDao;
import com.bms.agif.service.AgifRegionCheckService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guan_zhongheng on 2017/4/12.
 */
@Service
public class AgifRegionCheckServiceImpl extends BaseServiceImpl implements AgifRegionCheckService{

    @Autowired
    private AgifRegionCheckDao agifRegionCheckDao;

    @Override
    public BaseDao getBaseDao() {
        return agifRegionCheckDao;
    }

    @Override
    public int checkRegionNum(AgentParam param) {
        return agifRegionCheckDao.checkRegionNum(param);
    }

    @Override
    public int checkLgcsRegionNum(AgentDemesneParam param) {
        return agifRegionCheckDao.checkLgcsRegionNum(param);
    }
}
