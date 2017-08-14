package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerAccountRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerAccountAddValidator extends DefaultCustomValidator<ButlerAccountRsParam> {
    @Override
    public void validator(ButlerAccountRsParam param) {
        if (param != null) {
            this.validatorMaxLength("AGIF.L03002", param.getButlerId(), true, 36);
            this.validatorMaxLength("AGIF.L03003", param.getAccountName(), true, 16);
            this.validatorMaxLength("AGIF.L03005", param.getTelNo(), true, 16);
            this.validatorMaxLength("AGIF.L03004", param.getPassword(), true, 16);
            if(!StringUtils.isEmpty(param.getMailAddr())){
                this.validatorMaxLength("AGIF.L03006", param.getMailAddr(), true, 32);
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}

