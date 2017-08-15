package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0223IParam;
import com.bms.slim.bean.param.SLIM0226IParam;
import com.bms.slim.bean.result.field.SLIM0223ProducerHonorCertificateResult;
import com.bms.slim.bean.result.field.SLIM0226ProducerFactoryResult;
import com.bms.slim.dao.SLIM0223IDao;
import com.bms.slim.dao.SLIM0226IDao;
import com.bms.slim.services.SLIM0223IService;
import com.bms.slim.services.SLIM0226IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0226IServiceImpl extends BaseServiceImpl implements SLIM0226IService {

    @Autowired
    private SLIM0226IDao slim0226IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0226IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0226ProducerFactoryResult> findProducerFactory(SLIM0226IParam slim0226IParam) {
        BaseRestPaginationResult<SLIM0226ProducerFactoryResult> pagingResult = findPageList(slim0226IParam);
        return pagingResult;
    }

}
