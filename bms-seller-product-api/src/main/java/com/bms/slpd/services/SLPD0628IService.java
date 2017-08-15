package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import com.bms.slpd.bean.result.SLPD0628IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0628IService extends BaseService {

    /**
     * <p>新增饲养标准指标差异</p>
     */
    @Transactional
    SLPD0628IResult addDifFedStds(List<SLPD0628IFedDifStdParam> list);
}