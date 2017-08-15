package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdGnqStd;
import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import com.bms.slpd.bean.result.SLPD0613IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *新增通用质量标准指标档案卡
 */
public interface SLPD0613IService extends BaseService {

    /**
     *新增通用质量标准指标档案卡
     */
    @Transactional
    SLPD0613IResult saveGnqStandards(List<SLPD0613IGnqStdParam> params);
}