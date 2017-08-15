package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0250IParam;
import com.bms.slim.bean.result.field.SLIM0250IEntitySellerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0250IService extends BaseService {

    /**
     * 批量查询实体卖家、角色、卖家、卖家联系人
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0250IEntitySellerResult> findEntitySellers(SLIM0250IParam slim0250iParam);

}
