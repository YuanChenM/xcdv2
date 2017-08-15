package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import com.bms.slpd.bean.result.SLPD0634IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SLPD0634IService extends BaseService {
    /**
     * 新增加工质量标准差异
     */
    @Transactional
    SLPD0634IResult saveTncDifStds(List<SLPD0634ITncDifStdParam> insertList);
}