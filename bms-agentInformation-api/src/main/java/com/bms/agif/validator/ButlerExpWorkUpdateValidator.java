package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpWorkRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * @author zhao_chen
 * @version 1.0
 */
public class ButlerExpWorkUpdateValidator extends DefaultCustomValidator<BaseBean<ButlerExpWorkRsParam, ButlerExpWorkRsParam>> {

    @Override
    public void validator(BaseBean<ButlerExpWorkRsParam, ButlerExpWorkRsParam> param) {
        if (null != param) {
            if(param.getTarget().getDelFlg() == null){
                param.getTarget().setDelFlg(false);
            }
            ButlerExpWorkRsParam target = param.getTarget();
            ButlerExpWorkRsParam filter = param.getFilter();
            this.validatorLong("AGIF.L03026", filter.getWorkExpId(), true, Long.MAX_VALUE, 0L, 4);
            this.validatorMaxLength("AGIF.L03026", target.getCompany(), false, 32);
            this.validatorMaxLength("AGIF.L03027", target.getPost(), false, 16);
            this.validatorMaxLength("AGIF.L03029", target.getJob(), false, 16);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
