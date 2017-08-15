package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0229IParam;
import com.bms.slim.bean.result.field.SLIM0229ProducerWorkShopResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0229IService extends BaseService {

    /**
     * 查询生产商车间
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0229ProducerWorkShopResult> findProducerWorkShops(SLIM0229IParam slim0229IParam);

}
