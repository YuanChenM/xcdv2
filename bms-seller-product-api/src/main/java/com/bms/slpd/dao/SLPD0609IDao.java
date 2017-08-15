package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdMctStd;
import com.bms.slpd.bean.entity.target.SlpdMctStdTarget;
import com.framework.boot.base.BaseDao;

public interface SLPD0609IDao extends BaseDao {

    /**
     * 修改加工技术档案卡
     */
    int updateMctStd(UpdateEntity<SlpdMctStd, SlpdMctStdTarget> updateEntity);
}