package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.SLPD1808IManufacturerParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1808IDao extends BaseDao {

    /**
     * 删除制造商产品
     */
    int updateManufacturerProducts(SlpdManufacturerProduct params);

    /**
     * 查询已被使用的制造商Id
     */
    List<Long> findUsedManufacturerProducts(List<SLPD1808IManufacturerParam> manufacturerIds);

    /**
     * 根据制造商产品id查询制造商产品sku
     */
    String findManufacturerProductSku(Long manufacturerPdId);

}
