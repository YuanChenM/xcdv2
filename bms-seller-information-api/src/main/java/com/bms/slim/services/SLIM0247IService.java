package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0247IParam;
import com.bms.slim.bean.result.SLIM0247IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0247IService extends BaseService {

    /**
     * 新增卖方单位角色
     */
    @Transactional
    SLIM0247IResult saveSellerRoles(SLIM0247IParam slim0247IParam);

}
