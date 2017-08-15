package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0612IParam;
import com.bms.slpd.bean.param.field.SLPD0610ITncStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改加工质量标准Validator
 */
public class SLPD0612IValidator extends DefaultCustomValidator<SLPD0612IParam> {

    @Override
    public void validator(SLPD0612IParam slpd0612IParam) {
        if (null == slpd0612IParam) {
            return;
        }
        List<SLPD0610ITncStdParam> tncStdParams = slpd0612IParam.getTncStdParams();
        String[] targets = slpd0612IParam.getTargets();
        super.validatorRequired("tncStdParams", tncStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0610ITncStdParam param : tncStdParams) {
            this.validatorRequired("tncStdId", param.getTncStdId());
            this.validatorRequired("tncStdType", param.getTncStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("tncStdValA", param.getTncStdValA(), true, 256);
            super.validatorMaxLength("tncStdValB", param.getTncStdValB(), true, 256);
            super.validatorMaxLength("tncStdValC", param.getTncStdValC(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
