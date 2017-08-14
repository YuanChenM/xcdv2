/*
 * 2016/12/01 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.dao;

import com.bms.region.bean.param.CityLogRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>
 * RegnDistrictDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnDistrictDao extends BaseDao {

    List<CityLogRsParam> findLogDistrictList(CityLogRsParam param);
}