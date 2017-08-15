package com.bms.slim.dao;

import com.bms.slim.bean.UpdateEntity;
import com.framework.boot.base.BaseDao;

/**
 * Created by wang_haichun on 2017/1/12.
 *
 * 修改卖家品牌
 */
public interface SLIM0303IDao extends BaseDao {

    /**
     * 修改卖家品牌
     */
    int updateBrands(UpdateEntity var1);
}
