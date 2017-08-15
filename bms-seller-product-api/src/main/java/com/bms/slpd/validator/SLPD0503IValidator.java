package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0503IParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * 修改单品品牌Validator
 */
public class SLPD0503IValidator extends DefaultCustomValidator<SLPD0503IParam> {

    @Override
    public void validator(SLPD0503IParam slpd0503IParam) {
        /*this.validatorRequired(MessageConstant.Label.Beans,slpd0503IParam.getBeans());
        for (SLPD0503IParam param : slpd0503IParam.getBeans()) {
            this.validatorRequired(MessageConstant.Label.BrandItemId,param.getBrandItemId());
            this.validatorRequired(MessageConstant.Label.UpdId,param.getUpdId());
            this.validatorRequired(MessageConstant.Label.Version,param.getVersion());
        }*/
    }
}
