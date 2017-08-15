package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdSftStd;
import com.bms.slpd.bean.entity.target.SlpdSftStdTarget;
import com.framework.boot.base.BaseDao;


public interface SLPD0618IDao extends BaseDao {

    /**
     * 修改安全标准档案卡
     */
    int updateSftStd(UpdateEntity<SlpdSftStd, SlpdSftStdTarget> updateEntity);
}