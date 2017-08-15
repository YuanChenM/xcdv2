package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0630IParam;
import com.bms.slpd.bean.result.SLPD0630IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0630IService extends BaseService {

    /**
     * <p>修改饲养标准指标差异</p>
     */
    @Transactional
    SLPD0630IResult modifyDifFedStds(SLPD0630IParam param);

}