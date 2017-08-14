package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerExpWorkRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen
 * @version 1.0
 */
public class ButlerExpWorkAddValidator extends DefaultCustomValidator<ButlerExpWorkRsParam> {

    @Override
    public void validator(ButlerExpWorkRsParam param) {
        if (param != null) {
            /*this.validatorMaxLength("AGIF.L03025", param.getButlerId(), true, 36);*/
            this.validatorMaxLength("AGIF.L03002", param.getButlerId(), true, 36);

            this.validatorMaxLength("AGIF.L03026", param.getCompany(), false, 32);
            this.validatorMaxLength("AGIF.L03027", param.getPost(), false, 16);
            this.validatorMaxLength("AGIF.L03029", param.getJob(), false, 16);



        } else {
            this.validatorRequired("error.20002", null);
        }


    }
}
