package com.bms.agif.validator;

import com.bms.agif.bean.param.AccountParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
public class AccountAddValidator extends DefaultCustomValidator<AccountParam> {

    @Override
    public void validator(AccountParam param) {
        if (param != null) {
            this.validatorMaxLength("AGIF.L02012", param.getAgentId(), true, 36);
            this.validatorMaxLength("AGIF.L02003", param.getTelNo(), true, 16);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
