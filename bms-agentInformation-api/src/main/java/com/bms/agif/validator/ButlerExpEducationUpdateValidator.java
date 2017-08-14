package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpEducationRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen1
 * @version 1.0
 */
public class ButlerExpEducationUpdateValidator extends DefaultCustomValidator<BaseBean<ButlerExpEducationRsParam, ButlerExpEducationRsParam>> {

    @Override
    public void validator(BaseBean<ButlerExpEducationRsParam, ButlerExpEducationRsParam> param) {
        if (null != param) {
            if(param.getTarget().getDelFlg() == null){
                param.getTarget().setDelFlg(false);
            }
            ButlerExpEducationRsParam filter = param.getFilter();
            ButlerExpEducationRsParam target = param.getTarget();
            this.validatorLong("AGIF.L03021", filter.getEducationExpId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("AGIF.L03022", target.getSchool(), false, 32);
            this.validatorMaxLength("AGIF.L03024", target.getDegree(), false, 16);
            this.validatorMaxLength("AGIF.L03023", target.getEducation(), false, 16);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
