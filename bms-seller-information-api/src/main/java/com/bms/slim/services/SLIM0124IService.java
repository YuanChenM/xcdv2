package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0124IParam;
import com.bms.slim.bean.result.SLIM0124IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0124IService extends BaseService {

    /**
     * 修改卖家角色
     */
    @Transactional
    SLIM0124IResult updateSellers(SLIM0124IParam slim0124IParam);

}
