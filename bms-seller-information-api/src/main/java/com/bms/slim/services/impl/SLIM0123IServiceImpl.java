package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0123IParam;
import com.bms.slim.bean.result.field.SLIM0123SellerResult;
import com.bms.slim.dao.SLIM0123IDao;
import com.bms.slim.services.SLIM0123IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0123IServiceImpl extends BaseServiceImpl implements SLIM0123IService {

    @Autowired
    private SLIM0123IDao slim0123IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0123IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0123SellerResult> findSellers(SLIM0123IParam slim0123IParam) {
        BaseRestPaginationResult<SLIM0123SellerResult> pagingResult = findPageList(slim0123IParam);
        return pagingResult;
    }

}
