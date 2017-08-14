/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.dao;

import com.bms.bymt.bean.entity.BymtTerminalMarketBasic;
import com.framework.boot.base.BaseDao;

/**
 * <p>
 * BymtTerminalMarketBasicDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtTerminalMarketBasicDao extends BaseDao {

    public String findMaxMarketCode(BymtTerminalMarketBasic param);
}