package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0248IParam;
import com.bms.slim.bean.result.field.SLIM0248SellerRoleResult;
import com.bms.slim.dao.SLIM0248IDao;
import com.bms.slim.services.SLIM0248IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0248IServiceImpl extends BaseServiceImpl implements SLIM0248IService {

    @Autowired
    private SLIM0248IDao slim0248IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0248IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0248SellerRoleResult> findSellerRoles(SLIM0248IParam slim0248IParam) {
        BaseRestPaginationResult<SLIM0248SellerRoleResult> pagingResult = findPageList(slim0248IParam);
        return pagingResult;
    }

}
