package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0208IParam;
import com.bms.slim.bean.result.field.SLIM0208DesignatSlaughterPermitResult;
import com.bms.slim.dao.SLIM0208IDao;
import com.bms.slim.services.SLIM0208IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0208IServiceImpl extends BaseServiceImpl implements SLIM0208IService {

    @Autowired
    private SLIM0208IDao slim0208IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0208IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0208DesignatSlaughterPermitResult> findDesignatSlaughterPermit(SLIM0208IParam slim0208IParam) {
        BaseRestPaginationResult<SLIM0208DesignatSlaughterPermitResult> pagingResult = findPageList(slim0208IParam);
        return pagingResult;
    }

}
