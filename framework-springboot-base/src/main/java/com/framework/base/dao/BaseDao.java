package com.framework.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author liu_tao2
 * @version 1.0
 */
public interface BaseDao {

    <T> T findOne(Serializable param);

    <T> List<T> findAll();

    <T> List<T> findAll(Serializable param);

    <T> List<T> findAll(int delFlag);

    int save(Serializable param);

    int modify(Serializable param);

    int remove(Serializable param);

    int count();

    int count(int delFlag);

    <T> List<T> findPageList(Serializable pagePagingParam);

    int count(Serializable param);

    <T> int batchInsert(List<T> params);
}
