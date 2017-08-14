package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpTrainingRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen
 * @version 1.0
 */
public class ButlerExpTrainingUpdateValidator extends DefaultCustomValidator<BaseBean<ButlerExpTrainingRsParam, ButlerExpTrainingRsParam>> {

    @Override
    public void validator(BaseBean<ButlerExpTrainingRsParam, ButlerExpTrainingRsParam> param) {
        if (null != param) {
            if(param.getTarget().getDelFlg() == null){
                param.getTarget().setDelFlg(false);
            }
            ButlerExpTrainingRsParam filter = param.getFilter();
            ButlerExpTrainingRsParam target = param.getTarget();
            this.validatorLong("AGIF.L03013", filter.getTrainingExpId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("AGIF.L03017", target.getCertificate(), false, 32);
            this.validatorMaxLength("AGIF.L03016", target.getOrganization(), false, 36);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
