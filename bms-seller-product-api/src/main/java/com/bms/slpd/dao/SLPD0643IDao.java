package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdDifTspStd;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0643IDao extends BaseDao {
    /**
     * 新增存储运输标准指标差异
     */
    int saveTspDifStds(List<SlpdDifTspStd> tspDifStdList);

}