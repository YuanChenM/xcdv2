package com.bms.como.dao;

import com.bms.como.bean.entity.ComoShelfList;
import com.bms.como.bean.param.ComoAddOffShelfRsParam;
import com.bms.como.bean.param.ComoShelfListRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * Created by zhang_jian4 on 2017/3/30.
 */
public interface ComoAddOffShelfDao extends BaseDao {
    List<ComoShelfListRsParam> findShelfList(ComoAddOffShelfRsParam addOffShelfRsParam);
    int insertShelfList(ComoShelfList shelfList);
}
