package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0214IParam;
import com.bms.slim.bean.result.field.SLIM0214ShBjTjRegistrationResult;
import com.bms.slim.dao.SLIM0214IDao;
import com.bms.slim.services.SLIM0214IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0214IServiceImpl extends BaseServiceImpl implements SLIM0214IService {

    @Autowired
    private SLIM0214IDao slim0214IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0214IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0214ShBjTjRegistrationResult> findShBjTjRegistration(SLIM0214IParam slim0214IParam) {
        BaseRestPaginationResult<SLIM0214ShBjTjRegistrationResult> pagingResult = findPageList(slim0214IParam);
        return pagingResult;
    }

}
