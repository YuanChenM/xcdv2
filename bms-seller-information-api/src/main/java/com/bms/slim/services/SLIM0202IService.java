package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0202IParam;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0202IService extends BaseService {

    /**
     * 查询卖家生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SlimProducerResult> findSellerProducers(SLIM0202IParam slim0202IParam);

}
