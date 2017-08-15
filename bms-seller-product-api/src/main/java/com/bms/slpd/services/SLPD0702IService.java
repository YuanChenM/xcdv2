package com.bms.slpd.services;

import com.bms.slpd.bean.param.wrapper.SlpdProductProducerParam;
import com.bms.slpd.bean.result.SLPD0702IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD0702IService extends BaseService {

    /**
     * 新增单品品牌(规格)生产商
     */
    @Transactional
    SLPD0702IResult saveProducerProducts(List<SlpdProductProducerParam> insertList);

}
