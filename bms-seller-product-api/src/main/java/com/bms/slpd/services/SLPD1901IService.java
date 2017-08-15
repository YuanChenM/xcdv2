package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1901IParam;
import com.bms.slpd.bean.result.wrapper.SLPD1901INetWeightResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1901IService extends BaseService {

    /**
     * 批量净重列表
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1901INetWeightResult> findNetWeights(SLPD1901IParam slpd1901IParam);

}
