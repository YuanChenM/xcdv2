package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/*
 *修改品牌绑定关系
 */
public interface SLPD0408IDao extends BaseDao {
    /*
   *修改品牌绑定关系
   */
    int updateBrandOwnerRelations(UpdateEntity var1);
}