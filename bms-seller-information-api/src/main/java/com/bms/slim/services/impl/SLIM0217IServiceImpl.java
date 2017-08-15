package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0217IParam;
import com.bms.slim.bean.result.field.SLIM0217FoodProductionLicenseResult;
import com.bms.slim.dao.SLIM0217IDao;
import com.bms.slim.services.SLIM0217IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0217IServiceImpl extends BaseServiceImpl implements SLIM0217IService {

    @Autowired
    private SLIM0217IDao slim0217IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0217IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0217FoodProductionLicenseResult> findFoodProductionLicense(SLIM0217IParam slim0217IParam) {
        BaseRestPaginationResult<SLIM0217FoodProductionLicenseResult> pagingResult = findPageList(slim0217IParam);
        return pagingResult;
    }

}
