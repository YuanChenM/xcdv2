package com.bms.como.service;

import com.bms.como.bean.param.ComoAddOffShelfInfoRsParam;
import com.bms.como.bean.result.ComoAddOffShelfInfoRsResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang_jian4 on 2017/4/5.
 */
public interface ComoAddOffShelfInfoService extends BaseService {

    /**
     * 查询销售商品上下架数据
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<ComoAddOffShelfInfoRsResult> searchAddOffShelfInfo(ComoAddOffShelfInfoRsParam addOffShelfInfoRsParam);

}
