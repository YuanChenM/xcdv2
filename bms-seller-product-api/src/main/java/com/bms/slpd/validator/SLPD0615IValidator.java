package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0615IParam;
import com.bms.slpd.bean.param.field.SLPD0613IGnqStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/*
 * 修改通用质量标准指标
 */
public class SLPD0615IValidator extends DefaultCustomValidator<SLPD0615IParam> {
    @Override
    public void validator(SLPD0615IParam request) {
        if (null == request) {
            return;
        }
        List<SLPD0613IGnqStdParam> gnqStdParams = request.getGnqStdParams();
        String[] targets = request.getTargets();
        super.validatorRequired("gnqStdParams", gnqStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0613IGnqStdParam param : gnqStdParams) {
            this.validatorRequired("gnqStdId", param.getGnqStdId());
            this.validatorRequired("gnqStdType", param.getGnqStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("gnqOkVal", param.getGnqOkVal(), true, 256);
            super.validatorMaxLength("gnqNgVal", param.getGnqNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
