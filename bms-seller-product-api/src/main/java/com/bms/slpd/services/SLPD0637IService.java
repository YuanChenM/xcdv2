package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import com.bms.slpd.bean.result.SLPD0637IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0637IService extends BaseService {

    /**
     * <p>新增通用质量标准指标差异</p>
     */
    @Transactional
    SLPD0637IResult addDifGnqStds(List<SLPD0637IGnqDifStdParam> list);

}