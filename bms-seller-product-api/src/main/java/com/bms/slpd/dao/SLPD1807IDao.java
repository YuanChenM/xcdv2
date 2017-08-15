package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1807IDao extends BaseDao {
    /**
     * 新增制造商产品
     */
    int saveManufacturerProducts(List<SlpdManufacturerProduct> slpdManufacturerProducts);


    /**
     * 查询制造商产品是否存在
     */
    List<SlpdManufacturerProduct> findExistManufacturerProducts(List<SlpdManufacturerProduct> slpdManufacturerProducts);
}
