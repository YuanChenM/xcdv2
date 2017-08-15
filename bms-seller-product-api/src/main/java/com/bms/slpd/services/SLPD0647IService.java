package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0647IParam;
import com.bms.slpd.bean.result.SLPD0647IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 *<p>修改包装标准指标差异卡</p>
 */
public interface SLPD0647IService extends BaseService {

    /**
     *<p>修改包装标准指标差异卡</p>
     */
    @Transactional
    SLPD0647IResult updateDifPkgStandards(SLPD0647IParam requestParam);

}