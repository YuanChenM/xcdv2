package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0613IParam;
import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


public class SLPD0613IValidator extends DefaultCustomValidator<SLPD0613IParam> {
    @Override
    public void validator(SLPD0613IParam request) {
        if (null == request) {
            return;
        }
        List<SLPD0613IGnqStdParam> gnqStdParams = request.getGnqStdParams();
        super.validatorRequired("gnqStdParams", gnqStdParams);

        for (SLPD0613IGnqStdParam param : gnqStdParams) {
            this.validatorRequired("gnqStdType", param.getGnqStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("gnqOkVal", param.getGnqOkVal(), true, 256);
            super.validatorMaxLength("gnqNgVal", param.getGnqNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}

