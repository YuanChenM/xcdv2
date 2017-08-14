/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.dao;

import com.bms.byim.bean.entity.ByimMarketingStatus;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.framework.boot.base.BaseDao;

import java.util.List;

/**
 * <p>ByimMarketingStatusDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimMarketingStatusDao extends BaseDao {
    List<ByimMarketingStatus> findMarketingStatusListByParentId(ByimMarketingStatus marketingStatus);

    ByimMarketingStatus findMarketingStatusById(MarketingStatusRsParam statusParam);

    List<MarketingStatusRsParam> findItemList(MarketingStatusRsParam statusRsParam);

    List<MarketingStatusRsParam> findParentList();

    ByimMarketingStatus findNodePath(ByimMarketingStatus marketingStatus);

    List<ByimMarketingStatus> findMarketingStatusIds(ByimMarketingStatus marketingStatus);

    int deleteMarketingStatus(List marketingStatusIds);

    int findMarketingStatus(BaseBean<MarketingStatusRsParam, MarketingStatusRsParam> statusRsParam);

    int findMarketingStatusUse(List marketingStatusIds);
}