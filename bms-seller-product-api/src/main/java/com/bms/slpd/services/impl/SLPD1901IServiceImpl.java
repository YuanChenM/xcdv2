package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD1901IParam;
import com.bms.slpd.bean.result.wrapper.SLPD1901INetWeightResult;
import com.bms.slpd.dao.SLPD1901IDao;
import com.bms.slpd.services.SLPD0201IService;
import com.bms.slpd.services.SLPD1901IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLPD1901IServiceImpl extends BaseServiceImpl implements SLPD1901IService {

    @Autowired
    private SLPD0201IService slpd0201IService;
    @Autowired
    private SLPD1901IDao slpd1901IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd1901IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1901INetWeightResult> findNetWeights(SLPD1901IParam slpd1901IParam) {
        BaseRestPaginationResult<SLPD1901INetWeightResult> restResult = super.findPageList(slpd1901IParam);

        return restResult;
    }
}
