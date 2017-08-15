package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifTncStd;
import com.bms.slpd.bean.entity.target.SlpdDifTncStdTarget;
import com.framework.boot.base.BaseDao;


public interface SLPD0636IDao extends BaseDao {
    /**
     * 修改加工质量标准差异
     */
    int updateTncDifStd(UpdateEntity<SlpdDifTncStd, SlpdDifTncStdTarget> updateEntity);
}