package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0402IParam;
import com.bms.slpd.bean.result.SLPD0402IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改品牌
 */
public interface SLPD0402IService extends BaseService {
    /**
     * 修改品牌
     */
    @Transactional
    SLPD0402IResult updateBrands(SLPD0402IParam requestParam);


}