/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.param.ButlerBuyerRelationRsPageParam;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>AgifButlerBuyerRelationDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerBuyerRelationDao extends BaseDao {
    <T> List<T> findRelationPageList(Serializable var1);

    <T> List<T> findBuyerButlerAgentPageList(Serializable var1);

    Integer buyerCount(ButlerBuyerRelationRsPageParam butlerBuyerRelationRsPageParam);
}