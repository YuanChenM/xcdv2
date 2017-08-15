package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0506IParam;
import com.bms.slpd.bean.result.SLPD0506IResult;
import com.framework.base.rest.SearchRestRequest;
import com.framework.base.rest.result.BaseRestPagingResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0506IService extends BaseService {

    /**
     * <p>查询品牌单品关系</p>
     */
    @Transactional(readOnly = true)
    SLPD0506IResult findBrandItemsBySql(SLPD0506IParam restRequest);

}