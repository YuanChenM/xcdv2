package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import com.bms.slpd.bean.result.SLPD0619IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0619IService extends BaseService {

    /**
     * <p>新增储存运输标准指标</p>
     */
    @Transactional
    SLPD0619IResult addTspStds(List<SLPD0619ITspStdParam> list);

}