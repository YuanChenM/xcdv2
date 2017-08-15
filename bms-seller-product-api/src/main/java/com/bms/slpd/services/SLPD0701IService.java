package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0701IParam;
import com.bms.slpd.bean.result.field.SLPD0701IProducerProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0701IService extends BaseService {

    /**
     * 批量查询单品品牌(规格)生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD0701IProducerProductResult> findProducerProducts(SLPD0701IParam slpd0701IParam);

}
