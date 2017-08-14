package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerDemesneRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/10.
 */
public class ButlerDemesneUpdateValidator  extends DefaultCustomValidator<ButlerDemesneRsParam> {

    @Override
    public void validator(ButlerDemesneRsParam butlerDemesneRsParam) {
        if (butlerDemesneRsParam != null) {
            this.validatorLong("AGIF.L02033", butlerDemesneRsParam.getAgentDemesneId(), true, Long.MAX_VALUE, 0L, 4);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
