package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0642IParam;
import com.bms.slpd.bean.result.SLPD0642IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>修改安全标准指标差异卡</p>
 */
public interface SLPD0642IService extends BaseService {

    /**
     * <p>修改安全标准指标差异卡</p>
     */
    @Transactional
    SLPD0642IResult updateDifSftStandards(SLPD0642IParam requestParam);

}