package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1804IParam;
import com.bms.slpd.bean.result.field.SLPD1804IProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1804IService extends BaseService {

    /**
     * 批量查询单品品牌规格
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1804IProductResult> findProducts(SLPD1804IParam slpd1804iParam);

}