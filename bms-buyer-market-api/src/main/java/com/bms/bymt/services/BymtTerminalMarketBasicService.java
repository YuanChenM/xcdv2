/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BymtTerminalMarketBasicService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtTerminalMarketBasicService extends BaseService {

    @Transactional
    Integer addTerminalModuleBasic(List<TerminalMarketBasicRsParam> Params);

    @Transactional
    Integer updateTerminalMarketBasic(List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> param);

}