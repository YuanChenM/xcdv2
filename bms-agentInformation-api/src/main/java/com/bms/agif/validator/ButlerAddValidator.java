package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerAddValidator extends DefaultCustomValidator<ButlerRsParam> {

    @Override
    public void validator(ButlerRsParam param) {
        if (param != null) {
            this.validatorMaxLength("AGIF.L02012", param.getAgentId(), true, 36);
//            this.validatorMaxLength("AGIF.L03030", param.getButlerCode(), true, 24);
            this.validatorMaxLength("AGIF.L03031", param.getButlerName(), true, 32);

            if (!StringUtils.isEmpty(param.getButlerBirthday())) {
                this.validatorMaxLength("AGIF.L03032", param.getButlerBirthday(), true, 8);
            }
            if (!StringUtils.isEmpty(param.getButlerSex())) {
                this.validatorMaxLength("AGIF.L03033", param.getButlerSex(), true, 1);
            }
            if (!StringUtils.isEmpty(param.getButlerWechat())) {
                this.validatorMaxLength("AGIF.L03034", param.getButlerWechat(), true, 16);
            }
            if (!StringUtils.isEmpty(param.getButlerQq())) {
                this.validatorMaxLength("AGIF.L03035", param.getButlerQq(), true, 16);
            }
            if (!StringUtils.isEmpty(param.getIdCardFront())) {
                this.validatorMaxLength("AGIF.L03036", param.getIdCardFront(), true, 16);
            }
            if (!StringUtils.isEmpty(param.getIdCardBack())) {
                this.validatorMaxLength("AGIF.L03037", param.getIdCardBack(), true, 16);
            }

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
