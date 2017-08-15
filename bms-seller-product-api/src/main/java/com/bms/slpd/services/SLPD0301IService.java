package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0301IParam;
import com.bms.slpd.bean.result.SLPD0301IResult;
import com.bms.slpd.bean.result.field.SLPD0301IItemResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0301IService extends BaseService {

    /**
     * 批量查询单品
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD0301IItemResult> findItems(SLPD0301IParam slpd0301IParam);

}
