package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0235IParam;
import com.bms.slim.bean.result.field.SLIM0235ProducerLaboratoryResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0235IService extends BaseService {

    /**
     * 查询生产商实验室
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0235ProducerLaboratoryResult> findProducerLaboratories(SLIM0235IParam slim0235IParam);

}
