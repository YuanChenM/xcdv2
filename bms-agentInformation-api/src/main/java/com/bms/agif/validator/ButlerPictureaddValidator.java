package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerPictureRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerPictureaddValidator extends DefaultCustomValidator<ButlerPictureRsParam> {
    @Override
    public void validator(ButlerPictureRsParam param) {
        if (param != null) {
            this.validatorMaxLength("AGIF.L03002", param.getButlerId(), true, 36);
            this.validatorMaxLength("AGIF.L03012", param.getLicensePic(), true, 16);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
