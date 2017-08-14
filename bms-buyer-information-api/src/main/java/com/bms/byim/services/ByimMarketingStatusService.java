/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.entity.ByimMarketingStatus;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.bms.byim.bean.result.MarketingStatusTreeRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimMarketingStatusService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimMarketingStatusService extends BaseService {
    @Transactional(readOnly = true)
    List<ByimMarketingStatus> findMarketingStatusListByParentId(ByimMarketingStatus marketingStatus);

    @Transactional(readOnly = true)
    ByimMarketingStatus findMarketingStatusById(MarketingStatusRsParam statusParam);

    @Transactional(readOnly = true)
    MarketingStatusTreeRsResult findItemList(MarketingStatusRsParam statusRsParam);

    @Transactional(readOnly = true)
    MarketingStatusTreeRsResult findItemTree(MarketingStatusRsParam statusRsParam);

    @Transactional
    int saveStatusParamList(List<ByimMarketingStatus> statusParamList);

    @Transactional
    int modifyMarketingstatusList(List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> statusParamList);

    @Transactional(readOnly = true)
    int findMarketingStatus(List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> statusParamList);
}