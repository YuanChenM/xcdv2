package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1815IParam;
import com.bms.slpd.bean.result.field.SLPD1815IItemPropertyResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1815IService extends BaseService {

    /**
     * 批量查询单品规格
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1815IItemPropertyResult> findItemProperties(SLPD1815IParam slpd1815iParam);

}