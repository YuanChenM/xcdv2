package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 *<p>修改包装标准指标差异卡</p>
 */
public interface SLPD0647IDao extends BaseDao {
    int updateDifPkgStandards(UpdateEntity var1);
}