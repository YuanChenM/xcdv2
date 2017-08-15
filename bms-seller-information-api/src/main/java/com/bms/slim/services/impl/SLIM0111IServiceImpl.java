package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0111IParam;
import com.bms.slim.bean.result.field.SLIM0111AgentSupplyQualificationResult;
import com.bms.slim.dao.SLIM0111IDao;
import com.bms.slim.services.SLIM0111IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0111IServiceImpl extends BaseServiceImpl implements SLIM0111IService {

    @Autowired
    private SLIM0111IDao slim0111IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0111IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0111AgentSupplyQualificationResult> findAgentSupplyQualification(SLIM0111IParam slim0111IParam) {
        BaseRestPaginationResult<SLIM0111AgentSupplyQualificationResult> pagingResult = findPageList(slim0111IParam);
        return pagingResult;
    }

}
