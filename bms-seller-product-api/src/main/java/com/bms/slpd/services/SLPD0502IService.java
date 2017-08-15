package com.bms.slpd.services;

import com.bms.slpd.bean.param.wrapper.SlpdBrandItemParam;
import com.bms.slpd.bean.result.SLPD0502IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandItemResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0502IService extends BaseService {

    /**
     * <p>新增品牌单品</p>
     */
    @Transactional
    SLPD0502IResult addBrandItems(List<SlpdBrandItemParam> list);

    @Transactional(readOnly = true)
    int findBrandItemCount(List<SlpdBrandItemParam> insertList);

}