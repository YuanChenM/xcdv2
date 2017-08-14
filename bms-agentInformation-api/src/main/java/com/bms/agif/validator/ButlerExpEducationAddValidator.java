package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerExpEducationRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen
 * @version 1.0
 */
public class ButlerExpEducationAddValidator extends DefaultCustomValidator<ButlerExpEducationRsParam> {

    @Override
    public void validator(ButlerExpEducationRsParam param) {
        if (param != null) {
           /* "AGIF.L02034"*/
           /* this.validatorLong("教育经历ID", param.getEducationExpId(), false, Long.MAX_VALUE, 0L, 4);*/
            this.validatorMaxLength("AGIF.L03002", param.getButlerId(), true, 36);
            this.validatorMaxLength("AGIF.L03022", param.getSchool(), false, 32);
            this.validatorMaxLength("AGIF.L03024", param.getDegree(), false, 16);
            this.validatorMaxLength("AGIF.L03023", param.getEducation(), false, 16);
        } else {
            this.validatorRequired("error.20002", null);
        }

    }
}
