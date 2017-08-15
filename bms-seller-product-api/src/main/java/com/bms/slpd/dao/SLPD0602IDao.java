package com.bms.slpd.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

public interface SLPD0602IDao extends BaseDao {

    /**
     * <p>查询原种种源标准指标</p>
     */
    <T> List<T> batchSearch(Serializable var1);

    <T> List<T> searchStd(Serializable var1);

    <T> List<T> searchDif(Serializable var1);

}