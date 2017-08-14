package com.bms.como.service;

import com.bms.como.bean.param.SaleListRsParam;
import com.bms.como.bean.result.SaleListRsResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface ComoSaleListService extends BaseService {

    /**
     * 查询销售商品数据
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SaleListRsResult> findCommodity(SaleListRsParam saleListRsParam);

}
