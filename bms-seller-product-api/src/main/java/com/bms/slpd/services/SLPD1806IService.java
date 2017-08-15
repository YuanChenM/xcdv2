package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1806IParam;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1806IService extends BaseService {

    /**
     * 批量查询制造商单品品牌规格生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> findManufacturerProducts(SLPD1806IParam slpd1806iParam);

}