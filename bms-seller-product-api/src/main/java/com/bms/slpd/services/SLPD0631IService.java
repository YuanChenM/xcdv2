package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import com.bms.slpd.bean.result.SLPD0631IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *<p>新增加工技术标准指标差异卡</p>
 */
public interface SLPD0631IService extends BaseService {

    /**
     *<p>新增加工技术标准指标差异卡</p>
     */
    @Transactional
    SLPD0631IResult saveDifMctStandards(List<SLPD0631IMctDifStdParam> params);
}