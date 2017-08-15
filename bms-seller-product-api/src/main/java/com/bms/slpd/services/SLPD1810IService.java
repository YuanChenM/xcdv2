package com.bms.slpd.services;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.SLPD1810IParam;
import com.bms.slpd.bean.result.SLPD1810IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SLPD1810IService extends BaseService {

    /**
     * 根据ID 查询制造商信息
     */
    List<SlpdManufacturerProduct> findManufacturerProductById(List<Long> manufacturerProductIds);

    /**
     * 批量新增代理商单品品牌规格生产商
     */
    @Transactional
    SLPD1810IResult addAgentSupplyProducts(SLPD1810IParam slpd1810IParam);

}