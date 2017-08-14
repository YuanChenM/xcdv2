/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.FoodMarketTargetRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>BymtFoodMarketTargetService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtFoodMarketTargetService extends BaseService {

    @Transactional
    Integer executeInsert(List<FoodMarketTargetRsParam> rsParam);

    @Transactional
    Integer executeModify(List<BaseBean<FoodMarketTargetRsParam, FoodMarketTargetRsParam>> paramList);

    @Transactional(readOnly = true)
    FoodMarketTargetRsParam  findTotal(FoodMarketTargetRsParam param);

}