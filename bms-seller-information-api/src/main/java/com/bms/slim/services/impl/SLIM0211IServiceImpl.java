package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0211IParam;
import com.bms.slim.bean.result.field.SLIM0211HalalFoodProductionOperationLicenseResult;
import com.bms.slim.dao.SLIM0211IDao;
import com.bms.slim.services.SLIM0211IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0211IServiceImpl extends BaseServiceImpl implements SLIM0211IService {

    @Autowired
    private SLIM0211IDao slim0211IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0211IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0211HalalFoodProductionOperationLicenseResult> findHalalFoodProductionOperationLicense(SLIM0211IParam slim0211IParam) {
        BaseRestPaginationResult<SLIM0211HalalFoodProductionOperationLicenseResult> pagingResult = findPageList(slim0211IParam);
        return pagingResult;
    }

}
