package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0240IParam;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0240IService extends BaseService {

    /**
     * 查询平台生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SlimProducerResult> findProducers(SLIM0240IParam slim0240IParam);

}
