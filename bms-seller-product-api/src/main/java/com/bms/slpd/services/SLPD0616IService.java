package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.bms.slpd.bean.result.SLPD0616IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SLPD0616IService extends BaseService {
    /**
     * 新增安全标准档案卡
     */
    @Transactional
    SLPD0616IResult saveSftStds(List<SLPD0616ISftStdParam> insertList);

}