package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0704IDao extends BaseDao {

    /**
     * 根据产品ID，批量查询制造商产品
     */
    List<SlpdProduct> findProductsByIds(List<Long> producerProductIds);

    /**
     * 根据产品ID，批量查询制造商产品
     */
    List<SlpdManufacturerProduct> findManufacturerProductsByIds(List<Long> producerProductIds);

}
