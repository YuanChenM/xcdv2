package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.SLPD0805IParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0805IDao extends BaseDao {
    /**
     * 获取分页条数
     * @param pageParam
     * @return
     */
    List<SlpdSellerCommodity> findCommoditiesById(SLPD0805IParam pageParam);
}