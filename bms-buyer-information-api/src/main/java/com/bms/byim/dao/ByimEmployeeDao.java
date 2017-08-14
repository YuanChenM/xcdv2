/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.entity.ByimEmployee;
import com.framework.boot.base.BaseDao;

/**
 * <p>ByimEmployeeDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimEmployeeDao extends BaseDao {
    int modifyIsNewestBoss(ByimEmployee byimEmployee);
    int modifyFalse(ByimEmployee byimEmployee);
}