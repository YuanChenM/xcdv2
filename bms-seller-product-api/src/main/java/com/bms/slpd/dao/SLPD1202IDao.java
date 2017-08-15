
package com.bms.slpd.dao;

import com.bms.slpd.bean.param.SLPD1202IParam;
import com.bms.slpd.bean.result.field.SLPD1202ILgcsAreaCommodityResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD1202IDao extends BaseDao {

    /**
     * 批量查询物流区商品
     */
    List<SLPD1202ILgcsAreaCommodityResult> findLgcsCommodities(SLPD1202IParam param);
}