package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0615IParam;
import com.bms.slpd.bean.result.SLPD0615IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改通用质量标准指标档案卡
 */
public interface SLPD0615IService extends BaseService {

    /**
     * 修改通用质量标准指标档案卡
     */
    @Transactional
    SLPD0615IResult updateGnqStandards(SLPD0615IParam requestParam);

}