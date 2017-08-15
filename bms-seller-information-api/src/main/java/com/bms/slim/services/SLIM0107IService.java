package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0107IParam;
import com.bms.slim.bean.result.SLIM0107IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0107IService extends BaseService {

    /**
     * 新增卖家经营团队
     */
    @Transactional
    SLIM0107IResult addSellerManagementTeams(SLIM0107IParam slim0107IParam);

}
