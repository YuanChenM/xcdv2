package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.param.SLPD1808IManufacturerParam;
import com.bms.slpd.bean.param.SLPD1811IAgentProductParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1811IDao extends BaseDao {

    /**
     * 删除代理商产品
     */
    int updateAgentProducts(SlpdAgentSupplyProduct params);

}
