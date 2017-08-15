package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1809IParam;
import com.bms.slpd.bean.result.field.SLPD1809IAgentSupplyProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1809IService extends BaseService {

    /**
     * 批量查询代理商单品品牌规格生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1809IAgentSupplyProductResult> findAgentSupplyProducts(SLPD1809IParam slpd1809IParam);

}