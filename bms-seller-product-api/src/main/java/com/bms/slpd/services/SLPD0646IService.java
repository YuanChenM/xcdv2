package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0646IPkgDifStdParam;
import com.bms.slpd.bean.result.SLPD0646IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0646IService extends BaseService {

    /**
     * <p>新增包装标准指标差异</p>
     */
    @Transactional
    SLPD0646IResult addDifPkgStds(List<SLPD0646IPkgDifStdParam> list);
}