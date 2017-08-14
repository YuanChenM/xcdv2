package com.bms.bymt.validator;

import com.bms.bymt.bean.param.FoodGradeInfoParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
public class FoodGradeInfoSearchValidator extends DefaultCustomValidator<FoodGradeInfoParam> {
    @Override
    public void validator(FoodGradeInfoParam paramSearchRestRequest) {
        if (paramSearchRestRequest != null) {
            this.validatorRequired("BYMT.L00013", paramSearchRestRequest.getFoodMarketId());
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
