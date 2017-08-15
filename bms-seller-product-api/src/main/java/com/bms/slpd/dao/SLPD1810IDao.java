package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1810IDao extends BaseDao {

    /**
     * 根据ID 查询制造商信息
     */
    List<SlpdManufacturerProduct> findManufacturerProductById(List<Long> manufacturerProductIds);
}