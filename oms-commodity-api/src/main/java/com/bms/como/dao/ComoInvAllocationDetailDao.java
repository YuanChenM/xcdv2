/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>ComoInvAllocationDetailDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ComoInvAllocationDetailDao extends BaseDao {
    int checkDetailRepeat(Serializable var1);

    int modifyFactQty(Serializable var1);

    <T> List<T> findInvAllocationDetails(Serializable var1);
}