package com.bms.slpd.dao;

import com.framework.boot.base.BaseDao;

import java.util.List;
import java.util.Map;

public interface SLPD1805IDao extends BaseDao {

    /**
     * 根据品牌ID，批量查询品牌所有人
     */
    List<Map<String, Object>> findBrandOwnersByBrandIds(List<Long> brandIds);

}