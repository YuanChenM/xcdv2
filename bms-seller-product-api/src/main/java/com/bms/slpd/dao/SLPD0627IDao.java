package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdDifOrgStd;
import com.bms.slpd.bean.entity.target.SlpdDifOrgStdTarget;
import com.framework.boot.base.BaseDao;


public interface SLPD0627IDao extends BaseDao {

    /**
     * 修改原种种源标准指标差异
     */
    int updateOrgDifStd(UpdateEntity<SlpdDifOrgStd, SlpdDifOrgStdTarget> updateEntity);
}