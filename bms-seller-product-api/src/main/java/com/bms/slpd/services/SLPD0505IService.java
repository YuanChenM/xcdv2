package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0505IParam;
import com.bms.slpd.bean.result.SLPD0505IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改单品规格
 */
public interface SLPD0505IService extends BaseService {

    /**
     * 修改单品规格
     */
    @Transactional
    SLPD0505IResult updateItemProperties(SLPD0505IParam slpd0505IParam);

}