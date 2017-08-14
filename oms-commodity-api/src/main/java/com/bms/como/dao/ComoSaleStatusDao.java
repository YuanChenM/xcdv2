/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.dao;

import com.framework.boot.base.BaseDao;

import java.io.Serializable;

/**
 * <p>ComoSaleStatusDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ComoSaleStatusDao extends BaseDao {
    int checkCode(Serializable var1);

    int checkName(Serializable var1);

    int modifyDefault(Serializable var1);

    int findDefault();
}