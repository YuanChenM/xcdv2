package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0232IParam;
import com.bms.slim.bean.result.field.SLIM0232ProducerStorageCapacityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0232IService extends BaseService {

    /**
     * 查询生产商库容
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0232ProducerStorageCapacityResult> findProducerStorageCapacities(SLIM0232IParam slim0232IParam);

}
