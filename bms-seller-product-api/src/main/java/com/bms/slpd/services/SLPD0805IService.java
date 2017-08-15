package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0805IParam;
import com.bms.slpd.bean.result.field.SLPD0805ICommodityResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0805IService extends BaseService {

    /**
     * 批量查询卖家单品品牌(规格)生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD0805ICommodityResult> findSellerCommodities(SLPD0805IParam slpd0805IParam);

}