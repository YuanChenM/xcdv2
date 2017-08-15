package com.bms.slpd.dao;

import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0506IDao extends BaseDao {

    <T> List<T> findBrandOwners(List<Long> var1);
}