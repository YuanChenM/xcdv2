package com.bms.bymt.validator;

import com.bms.bymt.bean.param.MarketLevelStandardRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/15.
 */
public class MarketLevelStandardSaveValidator extends DefaultCustomValidator<MarketLevelStandardRsParam> {
    @Override
    public void validator(MarketLevelStandardRsParam levelStandardParam) {
        if (levelStandardParam != null) {
            this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00020", levelStandardParam.getStandardCode(), true, 2);
            this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00021", levelStandardParam.getStandardLevel(), true, 16);
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
