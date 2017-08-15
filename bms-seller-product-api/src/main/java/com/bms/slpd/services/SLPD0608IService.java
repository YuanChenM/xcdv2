package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0608IParam;
import com.bms.slpd.bean.result.SLPD0608IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0608IService extends BaseService {
    /**
     * 查询技工技术标准指标档案卡和差异卡信息
     */
    @Transactional(readOnly = true)
    SLPD0608IResult findMctStdsAndDifStds(SLPD0608IParam requestParam);

    /**
     * 设置查询参数
     */
    @Transactional(readOnly = true)
    SLPD0608IParam setParamIds(SLPD0608IParam param);
}
