package com.bms.slpd.services.impl;

import com.bms.slpd.dao.SLPD0602IDao;
import com.bms.slpd.services.SLPD0602IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SLPD0602IServiceImpl extends BaseServiceImpl implements SLPD0602IService {

    @Autowired
    private SLPD0602IDao slpd0602IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0602IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> List<T> batchSearch(Serializable var1) {
        return slpd0602IDao.batchSearch(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchStd(Serializable var1) {
        return slpd0602IDao.searchStd(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchDif(Serializable var1) {
        return slpd0602IDao.searchDif(var1);
    }

}