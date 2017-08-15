package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0205IParam;
import com.bms.slim.bean.result.field.SLIM0205AnimalEpidemicPreventionConditionCertificateResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0205IService extends BaseService {

    /**
     * 查询生产商生产资质-动物防疫条件合格证
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0205AnimalEpidemicPreventionConditionCertificateResult> findAnimalEpidemicPreventionConditionCertificate(SLIM0205IParam slim0205IParam);

}
