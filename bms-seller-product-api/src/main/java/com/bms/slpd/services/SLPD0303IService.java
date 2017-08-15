package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0303IParam;
import com.bms.slpd.bean.result.SLPD0303IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0303IService extends BaseService {

    /**
     * 修改单品
     */
    @Transactional
    SLPD0303IResult updateFeature(SLPD0303IParam requestParam);
}
