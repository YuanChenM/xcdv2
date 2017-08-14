package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerExpTrainingRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen
 * @version 1.0
 */
public class ButlerExpTrainingAddValidator extends DefaultCustomValidator<ButlerExpTrainingRsParam> {

    @Override
    public void validator(ButlerExpTrainingRsParam param) {
        if (null != param) {
            this.validatorMaxLength("AGIF.L03002", param.getButlerId(), true, 36);
            this.validatorMaxLength("AGIF.L03017", param.getCertificate(), false, 32);
            this.validatorMaxLength("AGIF.L03016", param.getOrganization(), false, 36);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
