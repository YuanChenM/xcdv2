package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0620IParam;
import com.bms.slpd.bean.result.SLPD0620IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0620IService extends BaseService {

    /**
     * <p>修改储存运输标准指标</p>
     */
    @Transactional
    SLPD0620IResult modifyTspStds(SLPD0620IParam param);

}