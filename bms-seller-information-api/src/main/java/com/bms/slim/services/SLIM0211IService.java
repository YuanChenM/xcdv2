package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0211IParam;
import com.bms.slim.bean.result.field.SLIM0211HalalFoodProductionOperationLicenseResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0211IService extends BaseService {

    /**
     * 查询生产商生产资质-清真食品生产经营许可证
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0211HalalFoodProductionOperationLicenseResult> findHalalFoodProductionOperationLicense(SLIM0211IParam slim0211IParam);

}
