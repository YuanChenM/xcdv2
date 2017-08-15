package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.bms.slpd.dao.SLPD0104IDao;
import com.bms.slpd.services.SLPD0104IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLPD0104IServiceImpl extends BaseServiceImpl implements SLPD0104IService {
    @Autowired
    private SLPD0104IDao slpd0104IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0104IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SlpdMachiningResult> findMachinings(SLPD0104IParam slpd0104IParam) {
        return slpd0104IDao.findMachinings(slpd0104IParam);
    }
}
