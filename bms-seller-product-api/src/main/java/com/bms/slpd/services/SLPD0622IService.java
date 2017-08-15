package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
import com.bms.slpd.bean.result.SLPD0622IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0622IService extends BaseService {

    /**
     * <p>新增储存运输标准指标</p>
     */
    @Transactional
    SLPD0622IResult addPkgStds(List<SLPD0622IPkgStdParam> list);

}