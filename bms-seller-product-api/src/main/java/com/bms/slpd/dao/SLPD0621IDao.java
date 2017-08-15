package com.bms.slpd.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

public interface SLPD0621IDao extends BaseDao {

    /**
     * <p>查询储存运输标准指标</p>
     */
    <T> List<T> batchSearch(Serializable var1);

    <T> List<T> searchStd(Serializable var1);

    <T> List<T> searchDif(Serializable var1);
}