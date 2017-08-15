package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import com.bms.slpd.bean.result.SLPD0601IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0601IService extends BaseService {

    /**
     * <p>新增原种种源标准指标</p>
     */
    @Transactional
    SLPD0601IResult addOrgStds(List<SLPD0601IOrgStdParam> list);

}