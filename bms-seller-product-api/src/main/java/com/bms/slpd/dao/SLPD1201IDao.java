
package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdLogisticsAreaProduct;
import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1201IDao extends BaseDao {

    /**
     * 批量新增物流区商品
     */
    int saveLgcsCommodities(List<SlpdLogisticsAreaProduct> lgcsAreaCommodities);

    /**
     * 查询已存在的物流区商品
     */
    List<SlpdLogisticsAreaProduct> findExistLgcsCommodities(List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities);
}