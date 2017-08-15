package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0639IParam;
import com.bms.slpd.bean.result.SLPD0639IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0639IService extends BaseService {

    /**
     * <p>修改通用质量标准指标差异</p>
     */
    @Transactional
    SLPD0639IResult modifyDifGnqStds(SLPD0639IParam param);

}