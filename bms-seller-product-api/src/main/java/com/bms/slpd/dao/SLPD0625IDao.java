package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdDifOrgStd;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0625IDao extends BaseDao {
    /**
     * 新增原种种源标准指标差异
     */
    int saveOrgDifStds(List<SlpdDifOrgStd> orgDifStdList);
}