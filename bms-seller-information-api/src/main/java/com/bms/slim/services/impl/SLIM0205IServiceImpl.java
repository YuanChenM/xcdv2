package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0205IParam;
import com.bms.slim.bean.result.field.SLIM0205AnimalEpidemicPreventionConditionCertificateResult;
import com.bms.slim.dao.SLIM0205IDao;
import com.bms.slim.services.SLIM0205IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0205IServiceImpl extends BaseServiceImpl implements SLIM0205IService {

    @Autowired
    private SLIM0205IDao slim0205IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0205IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0205AnimalEpidemicPreventionConditionCertificateResult> findAnimalEpidemicPreventionConditionCertificate(SLIM0205IParam slim0205IParam) {
        BaseRestPaginationResult<SLIM0205AnimalEpidemicPreventionConditionCertificateResult> pagingResult = findPageList(slim0205IParam);
        return pagingResult;
    }

}
