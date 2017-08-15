package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0102IParam;
import com.bms.slim.bean.result.field.SLIM0102IEntitySellerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0102IService extends BaseService {

    /**
     * 批量查询卖家、实体卖家、卖家、卖家联系人
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0102IEntitySellerResult> findEntitySellers(SLIM0102IParam slim0102iParam);

}
