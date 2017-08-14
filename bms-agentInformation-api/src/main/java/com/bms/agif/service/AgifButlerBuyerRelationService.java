/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service;

import com.bms.agif.bean.param.ButlerBuyerRelationRsPageParam;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>AgifButlerBuyerRelationService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerBuyerRelationService extends BaseService {
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findRelationPageList(T var1);
    <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findBuyerButlerAgentPageList(T var1);

        Integer buyerCount (ButlerBuyerRelationRsPageParam butlerBuyerRelationRsPageParam);

        int bing(List<ButlerBuyerRelationRsPageParam> pageParam);

        int unBind(List<ButlerBuyerRelationRsPageParam> paramList);
}