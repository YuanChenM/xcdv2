package com.bms.como.service;

import com.bms.como.bean.param.ComoManufactureRsParam;
import com.bms.como.bean.param.ComoProductRsParam;
import com.bms.como.bean.result.ComoManufactureRsResult;
import com.bms.como.bean.result.ComoProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wang_haichun on 2017/3/29.
 */
public interface ComoManufactureService extends BaseService {

    /**
     * 查询商品生产商信息
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<ComoManufactureRsResult> searchComoManufacture(ComoManufactureRsParam comoManufactureRsParam);
}
