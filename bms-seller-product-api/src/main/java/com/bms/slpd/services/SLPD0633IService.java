package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0633IParam;
import com.bms.slpd.bean.result.SLPD0633IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>修改加工技术标准指标差异卡</p>
 */
public interface SLPD0633IService extends BaseService {


    /**
     * <p>修改加工技术标准指标差异卡</p>
     */
    @Transactional
    SLPD0633IResult updateDifMctStandards(SLPD0633IParam requestParam);

}