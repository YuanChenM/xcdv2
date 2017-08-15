package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0619IParam;
import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增储存运输标准指标Validator
 */
public class SLPD0619IValidator extends DefaultCustomValidator<SLPD0619IParam> {

    @Override
    public void validator(SLPD0619IParam slpd0619IParam) {
        if (null == slpd0619IParam) {
            return;
        }
        List<SLPD0619ITspStdParam> tspStdParams = slpd0619IParam.getTspStdParams();
        super.validatorRequired("tspStdParams", tspStdParams);

        for (SLPD0619ITspStdParam param : tspStdParams) {
            this.validatorRequired("tspStdType", param.getTspStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("tspOkVal", param.getTspOkVal(), true, 256);
            super.validatorMaxLength("tspNgVal", param.getTspNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
