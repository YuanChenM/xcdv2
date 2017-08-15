package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1812IParam;
import com.bms.slpd.bean.result.field.SLPD1812IProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1812IService extends BaseService {

    /**
     * 批量查询单品品牌规格
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1812IProductResult> findProducts(SLPD1812IParam slpd1812iParam);

}