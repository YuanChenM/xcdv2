package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0114IParam;
import com.bms.slim.bean.result.field.SLIM0114ManufacturerSupplyQualificationResult;
import com.bms.slim.dao.SLIM0114IDao;
import com.bms.slim.services.SLIM0114IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLIM0114IServiceImpl extends BaseServiceImpl implements SLIM0114IService {

    @Autowired
    private SLIM0114IDao slim0114IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0114IDao;
    }

    @Override
    public BaseRestPaginationResult<SLIM0114ManufacturerSupplyQualificationResult> findManufacturerSupplyQualification(SLIM0114IParam slim0114IParam) {
        BaseRestPaginationResult<SLIM0114ManufacturerSupplyQualificationResult> pagingResult = findPageList(slim0114IParam);
        return pagingResult;
    }

}
