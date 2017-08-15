package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0248IParam;
import com.bms.slim.bean.result.field.SLIM0248SellerRoleResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0248IService extends BaseService {

    /**
     * 查询卖方单位角色
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0248SellerRoleResult> findSellerRoles(SLIM0248IParam slim0248IParam);

}
