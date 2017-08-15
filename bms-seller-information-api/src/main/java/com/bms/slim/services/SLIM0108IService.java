package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0108IParam;
import com.bms.slim.bean.result.field.SLIM0108SellerManagementTeamResult;
import com.bms.slim.bean.result.wrapper.SlimProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0108IService extends BaseService {

    /**
     * 查询卖家经营团队
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0108SellerManagementTeamResult> findSellerManagementTeams(SLIM0108IParam slim0108IParam);

}
