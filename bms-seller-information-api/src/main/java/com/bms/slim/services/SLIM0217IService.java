package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0217IParam;
import com.bms.slim.bean.result.field.SLIM0217FoodProductionLicenseResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0217IService extends BaseService {

    /**
     * 查询生产商生产资质-食品生产许可证
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0217FoodProductionLicenseResult> findFoodProductionLicense(SLIM0217IParam slim0217IParam);

}
