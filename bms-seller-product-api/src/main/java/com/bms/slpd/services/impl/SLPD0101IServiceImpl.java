package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.param.SLPD0101IParam;
import com.bms.slpd.dao.SLPD0101IDao;
import com.bms.slpd.services.SLPD0101IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SLPD0101IServiceImpl extends BaseServiceImpl implements SLPD0101IService {

    @Autowired
    private SLPD0101IDao slpd0101IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0101IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SlpdClasses> findClasses(SLPD0101IParam slpd0101IParam) {
        return slpd0101IDao.findClasses(slpd0101IParam);
    }
}