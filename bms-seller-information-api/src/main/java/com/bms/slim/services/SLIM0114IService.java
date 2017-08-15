package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0114IParam;
import com.bms.slim.bean.result.field.SLIM0114ManufacturerSupplyQualificationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0114IService extends BaseService {

    /**
     * 查询卖家制造商供应资质
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0114ManufacturerSupplyQualificationResult> findManufacturerSupplyQualification(SLIM0114IParam slim0114IParam);

}
