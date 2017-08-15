package com.bms.slpd.services;

import com.bms.slpd.bean.param.wrapper.SLPD0302IItemParam;
import com.bms.slpd.bean.result.SLPD0302IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0302IService extends BaseService {
    /**
     * 新增单品
     */
    @Transactional
    SLPD0302IResult saveItems(List<SLPD0302IItemParam> insertList);
}
