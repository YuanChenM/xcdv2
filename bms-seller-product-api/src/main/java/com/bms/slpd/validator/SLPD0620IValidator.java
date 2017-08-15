package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0620IParam;
import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改储存运输标准指标Validator
 */
public class SLPD0620IValidator extends DefaultCustomValidator<SLPD0620IParam> {

    @Override
    public void validator(SLPD0620IParam slpd0620IParam) {
        if (null == slpd0620IParam) {
            return;
        }
        List<SLPD0619ITspStdParam> tspStdParams = slpd0620IParam.getTspStdParams();
        String[] targets = slpd0620IParam.getTargets();
        super.validatorRequired("tspStdParams", tspStdParams);
        super.validatorRequired("targets", targets);


        for (SLPD0619ITspStdParam param : tspStdParams) {
            this.validatorRequired("tspStdId", param.getTspStdId());
            this.validatorRequired("tspStdType", param.getTspStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("tspOkVal", param.getTspOkVal(), true, 256);
            super.validatorMaxLength("tspNgVal", param.getTspNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
