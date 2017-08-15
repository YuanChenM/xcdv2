package com.bms.order.services.impl;

import com.bms.order.dao.ORDR1201IDao;
import com.bms.order.services.ORDR1201IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sun_jiaju on 2017/5/10.
 */
@Service
public class ORDR1201IServiceImpl extends BaseServiceImpl implements ORDR1201IService {
    @Autowired
    private ORDR1201IDao ordr1201IDao;

    @Override
    public BaseDao getBaseDao() {
        return ordr1201IDao;
    }
}
