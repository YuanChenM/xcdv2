/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BymtFoodMarketBasicService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtFoodMarketBasicService extends BaseService {

    @Transactional
    int addFoodMarketBasic(List<MarketFoodModuleBasicRsParam> param);

    @Transactional
    Integer updateFoodMarketBasic(List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> param);


}