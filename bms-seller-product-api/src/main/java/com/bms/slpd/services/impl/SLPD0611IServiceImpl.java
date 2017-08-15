package com.bms.slpd.services.impl;

import com.bms.slpd.dao.SLPD0611IDao;
import com.bms.slpd.services.SLPD0611IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SLPD0611IServiceImpl extends BaseServiceImpl implements SLPD0611IService {

    @Autowired
    private SLPD0611IDao slpd0611IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0611IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Serializable> List<T> batchSearch(Serializable var1) {
        return slpd0611IDao.batchSearch(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchStd(Serializable var1) {
        return slpd0611IDao.searchStd(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchDif(Serializable var1) {
        return slpd0611IDao.searchDif(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchDiscuss(Serializable var1){
        return slpd0611IDao.searchDiscuss(var1);
    }

    @Override
    public <T extends Serializable> List<T> searchDifDiscuss(Serializable var1){
        return slpd0611IDao.searchDifDiscuss(var1);
    }

}