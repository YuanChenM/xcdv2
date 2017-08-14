package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class TerminalModuleBasicSearchValidator extends DefaultCustomValidator<TerminalMarketBasicRsParam> {

    @Override
    public void validator(TerminalMarketBasicRsParam marketBasicRsParam) {
        if (marketBasicRsParam != null) {
            //分页参数处理
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
