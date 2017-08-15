package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import com.bms.slpd.bean.result.SLPD0625IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SLPD0625IService extends BaseService {
    /**
     * 新增原种种源标准指标差异
     */
    @Transactional
    SLPD0625IResult saveOrgDifStds(List<SLPD0625IOrgDifStdParam> insertList);
}