package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0214IParam;
import com.bms.slim.bean.result.field.SLIM0214ShBjTjRegistrationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0214IService extends BaseService {

    /**
     * 查询生产商生产资质-进沪(京、津)登记信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0214ShBjTjRegistrationResult> findShBjTjRegistration(SLIM0214IParam slim0214IParam);

}
