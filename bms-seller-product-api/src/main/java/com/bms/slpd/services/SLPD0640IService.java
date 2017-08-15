package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import com.bms.slpd.bean.result.SLPD0640IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>新增安全标准指标差异卡</p>
 */
public interface SLPD0640IService extends BaseService {

    /**
     * <p>新增安全标准指标差异卡</p>
     */
    @Transactional
    SLPD0640IResult saveDifSftStandards(List<SLPD0640ISftDifStdParam> params);
}