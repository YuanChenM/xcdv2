package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import com.bms.slpd.bean.result.SLPD0607IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0607IService extends BaseService {
    /**
     * 新增加工技术标准指标
     */
    @Transactional
    SLPD0607IResult saveMctStds(List<SLPD0607IMctStdParam> insertList);

}