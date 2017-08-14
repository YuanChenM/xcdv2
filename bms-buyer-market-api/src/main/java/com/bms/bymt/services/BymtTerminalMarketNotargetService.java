/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.entity.BymtTerminalMarketNotarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketNotargetRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BymtTerminalMarketNotargetService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtTerminalMarketNotargetService extends BaseService {
    @Transactional
    int saveMarketNotargetList(List<BymtTerminalMarketNotarget> marketNotargetEntityList);

    @Transactional
    int modifyMarketNoTargetBuyerList(List<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>> noTargetBuyerList);

    @Transactional(readOnly = true)
    TerminalMarketNotargetRsParam findSum(TerminalMarketNotargetRsParam marketNotargetParam);
}