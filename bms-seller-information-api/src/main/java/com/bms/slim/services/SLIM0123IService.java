package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0123IParam;
import com.bms.slim.bean.result.field.SLIM0123SellerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0123IService extends BaseService {

    /**
     * 查询卖家角色
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0123SellerResult> findSellers(SLIM0123IParam slim0123IParam);

}
