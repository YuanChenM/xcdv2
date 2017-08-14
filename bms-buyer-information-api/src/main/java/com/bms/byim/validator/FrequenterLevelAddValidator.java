package com.bms.byim.validator;

import com.bms.byim.bean.param.FrequenterLevelRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/3/22.
 */
public class FrequenterLevelAddValidator extends DefaultCustomValidator<FrequenterLevelRsParam> {
    @Override
    public void validator(FrequenterLevelRsParam levelRsParam) {
        if (levelRsParam != null) {
            this.validatorRequired("BYIM.L00051", levelRsParam.getBuyerId());
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
