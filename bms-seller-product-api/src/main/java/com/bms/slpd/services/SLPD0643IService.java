package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import com.bms.slpd.bean.result.SLPD0643IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SLPD0643IService extends BaseService {
    /**
     * 新增存储运输标准指标差异
     */
    @Transactional
    SLPD0643IResult saveTspDifStds(List<SLPD0643ITspDifStdParam> insertList);
}