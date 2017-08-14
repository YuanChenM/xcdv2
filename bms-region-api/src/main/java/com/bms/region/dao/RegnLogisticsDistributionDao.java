/*
 * 2017/02/16 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.region.dao;

import com.bms.region.bean.param.RegnLogDistributionParam;
import com.framework.boot.base.BaseDao;

/**
 * <p>
 * RegnLogisticsDistributionDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface RegnLogisticsDistributionDao extends BaseDao {

    String findMaxCode(RegnLogDistributionParam param);

    int getParamCount(RegnLogDistributionParam param);
}