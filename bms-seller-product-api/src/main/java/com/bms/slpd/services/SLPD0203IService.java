package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD0203IParam;
import com.bms.slpd.bean.result.SLPD0203IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD0203IService extends BaseService {

    /**
     * <p>根据updateFlg修改一级分类,二级分类,品种</p>
     */
    @Transactional
    SLPD0203IResult updateBreedByFlg(SLPD0203IParam requestParam);

}
