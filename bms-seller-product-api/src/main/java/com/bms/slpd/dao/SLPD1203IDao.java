
package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdLogisticsAreaProduct;
import com.framework.boot.base.BaseDao;

public interface SLPD1203IDao extends BaseDao {

    /**
     * 物流区商品批量上下架
     */
    int updateLgcsCommodities(SlpdLogisticsAreaProduct param);
}