package com.bms.slpd.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

public interface SLPD0611IDao extends BaseDao {

    /**
     * <p>查询加工质量标准</p>
     */
    <T> List<T> batchSearch(Serializable var1);

    <T> List<T> searchStd(Serializable var1);

    <T> List<T> searchDif(Serializable var1);

    <T extends Serializable> List<T> searchDiscuss(Serializable var1);

    <T extends Serializable> List<T> searchDifDiscuss(Serializable var1);
}