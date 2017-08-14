/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>BypoStandardProductDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BypoStandardProductDao extends BaseDao {
    int standardProductIsExist(Serializable var1);

    <T> List<T> findStandardProduct(Serializable var1);
}