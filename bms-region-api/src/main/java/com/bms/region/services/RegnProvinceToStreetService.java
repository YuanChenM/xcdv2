package com.bms.region.services;

import com.bms.region.bean.param.RegnRelationParam;
import com.bms.region.bean.result.RegnRelationResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guan_zhongheng on 2017/2/15.
 */
public interface RegnProvinceToStreetService extends BaseService {

    @Transactional(readOnly = true)
    BaseRestPaginationResult<RegnRelationResult> findProvincePageList(RegnRelationParam param);
}
