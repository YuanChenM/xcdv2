package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 *<p>修改安全标准指标差异卡</p>
 */
public interface SLPD0642IDao extends BaseDao {
    int updateDifSftStandards(UpdateEntity var1);
}