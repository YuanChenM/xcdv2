package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifTspStd;
import com.bms.slpd.bean.entity.target.SlpdDifTspStdTarget;
import com.framework.boot.base.BaseDao;


public interface SLPD0644IDao extends BaseDao {
    /**
     * 修改储存运输标准指标差异
     */
    int updateTspDifStd(UpdateEntity<SlpdDifTspStd, SlpdDifTspStdTarget> updateEntity);
}