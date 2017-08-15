package com.bms.slpd.services.impl;

import com.bms.slpd.dao.SLPD0621IDao;
import com.bms.slpd.services.SLPD0621IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SLPD0621IServiceImpl extends BaseServiceImpl implements SLPD0621IService {

    @Autowired
    private SLPD0621IDao slpd0621IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0621IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> List<T> batchSearch(Serializable var1) {
        return slpd0621IDao.batchSearch(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchStd(Serializable var1) {
        return slpd0621IDao.searchStd(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchDif(Serializable var1) {
        return slpd0621IDao.searchDif(var1);
    }

}