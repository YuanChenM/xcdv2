package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1202IParam;
import com.bms.slpd.bean.result.field.SLPD1202ILgcsAreaCommodityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1202IService extends BaseService {
    /**
     * 批量查询物流区商品
     */
    @Transactional
    BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> findLgcsCommodities(SLPD1202IParam param);
}
