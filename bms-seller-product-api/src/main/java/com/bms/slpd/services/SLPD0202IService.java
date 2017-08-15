package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0202IParam;
import com.bms.slpd.bean.result.SLPD0202IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0202IService extends BaseService {

    /**
     * <p>根据insertFlg新增一级分类,二级分类,品种</p>
     */
    @Transactional
    SLPD0202IResult saveBreedsByFlg(SLPD0202IParam slpd0202IParam);
}
