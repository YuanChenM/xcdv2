package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0223IParam;
import com.bms.slim.bean.result.field.SLIM0223ProducerHonorCertificateResult;
import com.bms.slim.dao.SLIM0223IDao;
import com.bms.slim.services.SLIM0223IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0223IServiceImpl extends BaseServiceImpl implements SLIM0223IService {

    @Autowired
    private SLIM0223IDao slim0223IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0223IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0223ProducerHonorCertificateResult> findProducerHonorCertificate(SLIM0223IParam slim0223IParam) {
        BaseRestPaginationResult<SLIM0223ProducerHonorCertificateResult> pagingResult = findPageList(slim0223IParam);
        return pagingResult;
    }

}
