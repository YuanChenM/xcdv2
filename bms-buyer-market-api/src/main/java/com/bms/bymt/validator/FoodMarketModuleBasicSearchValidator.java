package com.bms.bymt.validator;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class FoodMarketModuleBasicSearchValidator extends DefaultCustomValidator<MarketFoodModuleBasicRsParam> {

    @Override
    public void validator(MarketFoodModuleBasicRsParam param) {
        if (param != null) {
            //分页参数处理
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }

    }
}
