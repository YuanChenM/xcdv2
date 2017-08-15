package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0220IParam;
import com.bms.slim.bean.result.field.SLIM0220IsoManagementSystemCertificationResult;
import com.bms.slim.dao.SLIM0220IDao;
import com.bms.slim.services.SLIM0220IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0220IServiceImpl extends BaseServiceImpl implements SLIM0220IService {

    @Autowired
    private SLIM0220IDao slim0220IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0220IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0220IsoManagementSystemCertificationResult> findIsoManagementSystemCertification(SLIM0220IParam slim0220IParam) {
        BaseRestPaginationResult<SLIM0220IsoManagementSystemCertificationResult> pagingResult = findPageList(slim0220IParam);
        return pagingResult;
    }

}
