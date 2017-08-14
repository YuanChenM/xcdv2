/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.dao;

import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>RegnLogisticsAreaDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnLogisticsAreaDao extends BaseDao {
    Integer checkedLgcsAreaId(LogisticsAreaRsParam param);
    List<LogisticsAreaRsParam> checkData(LogisticsAreaRsParam param);

}