/*
 * 2017/02/22 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;


import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>ByimStandardFrequenterLevelDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimStandardFrequenterLevelDao extends BaseDao {
    List<StandardFrequenterLevelRsParam> findLevelStandards();
}