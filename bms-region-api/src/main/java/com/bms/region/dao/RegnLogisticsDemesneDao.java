/*
 * 2017/02/16 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.dao;

import com.bms.region.bean.param.RegnLogDemesneParam;
import com.framework.boot.base.BaseDao;

/**
 * <p>
 * RegnLogisticsDemesneDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnLogisticsDemesneDao extends BaseDao {

    String findMaxCode(RegnLogDemesneParam param);

    int getParamCount(RegnLogDemesneParam param);
}