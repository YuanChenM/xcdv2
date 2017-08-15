package com.bms.slim.services;

import com.bms.slim.bean.param.SLIM0245IParam;
import com.bms.slim.bean.result.field.SLIM0245IContactResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLIM0245IService extends BaseService {

    /**
     * 分页查询卖家合同信息准入
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLIM0245IContactResult> findContacts(SLIM0245IParam param);
}
