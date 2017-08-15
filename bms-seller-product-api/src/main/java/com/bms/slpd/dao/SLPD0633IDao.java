package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;

/**
 *<p>修改加工技术标准指标差异卡</p>
 */
public interface SLPD0633IDao extends BaseDao {

    <T extends Serializable> int modifyDifMctStandards(UpdateEntity var1);
}