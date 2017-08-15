package com.bms.slpd.services;

import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.bms.slpd.bean.result.SLPD1201IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD1201IService extends BaseService {
    /**
     * 批量新增物流区商品
     */
    @Transactional
    SLPD1201IResult saveLgcsCommodities(List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities);
}
