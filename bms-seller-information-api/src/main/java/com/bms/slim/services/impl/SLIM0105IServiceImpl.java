package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.SLIM0105IParam;
import com.bms.slim.dao.SLIM0105IDao;
import com.bms.slim.services.SLIM0105IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0105IServiceImpl extends BaseServiceImpl implements SLIM0105IService {
    @Autowired
    private SLIM0105IDao slim0105IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0105IDao;
    }

    @Override
    public SlimSellerBusinessQualification findSBQ(SLIM0105IParam entitySellerId) {

        return slim0105IDao.findSBQ(entitySellerId);
    }
}
