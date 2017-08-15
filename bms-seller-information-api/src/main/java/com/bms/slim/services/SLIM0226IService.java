package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0226IParam;
import com.bms.slim.bean.result.field.SLIM0226ProducerFactoryResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0226IService extends BaseService {

    /**
     * 查询生产商工厂
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0226ProducerFactoryResult> findProducerFactory(SLIM0226IParam slim0226IParam);

}
