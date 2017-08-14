/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.param.ButlerRsParam;
import com.framework.boot.base.BaseDao;

/**
 * <p>AgifButlerDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerDao extends BaseDao {
    ButlerRsParam selectButlerTel(ButlerRsParam butlerRsParam);
    String selectAgent(ButlerRsParam butlerRsParam);
}