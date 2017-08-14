/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.entity.BymtTerminalMarketTarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketTargetRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BymtTerminalMarketTargetService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtTerminalMarketTargetService extends BaseService {

    @Transactional
    Integer executeInsert(List<List<BymtTerminalMarketTarget>> entityList);

    @Transactional
    int executeModify(List<BaseBean<BymtTerminalMarketTarget, BymtTerminalMarketTarget>> paramList);

    @Transactional(readOnly = true)
    TerminalMarketTargetRsParam findSum(TerminalMarketTargetRsParam marketTargetRsParam);
}