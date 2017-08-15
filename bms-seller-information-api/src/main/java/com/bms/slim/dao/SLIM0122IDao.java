package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimSeller;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0122IDao extends BaseDao {

    /**
     * 新增卖家角色
     */
    int saveSellers(List<SlimSeller> slimSellers);

}
