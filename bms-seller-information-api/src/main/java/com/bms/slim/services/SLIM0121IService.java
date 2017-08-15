package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0121IParam;
import com.bms.slim.bean.result.SLIM0121IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0121IService extends BaseService {

    /**
     * 修改卖家电商经营团队
     */
    @Transactional
    SLIM0121IResult updateSellerBusinessTeams(SLIM0121IParam slim0121IParam);

}
