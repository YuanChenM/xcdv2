package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0235IParam;
import com.bms.slim.bean.result.field.SLIM0235ProducerLaboratoryResult;
import com.bms.slim.dao.SLIM0235IDao;
import com.bms.slim.services.SLIM0235IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0235IServiceImpl extends BaseServiceImpl implements SLIM0235IService {

    @Autowired
    private SLIM0235IDao slim0235IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0235IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0235ProducerLaboratoryResult> findProducerLaboratories(SLIM0235IParam slim0235IParam) {
        BaseRestPaginationResult<SLIM0235ProducerLaboratoryResult> pagingResult = findPageList(slim0235IParam);
        return pagingResult;
    }

}
