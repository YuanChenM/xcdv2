package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0501IParam;
import com.bms.slpd.bean.result.field.SLPD0501IProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0501IService extends BaseService {

    /**
     * 批量查询产品
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD0501IProductResult> findProducts(SLPD0501IParam slpd0501iParam);

}