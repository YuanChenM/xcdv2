package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0609IParam;
import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0609IValidator extends DefaultCustomValidator<SLPD0609IParam> {
    @Override
    public void validator(SLPD0609IParam slpd0609IParam) {
        if (null == slpd0609IParam) {
            return;
        }
        List<SLPD0607IMctStdParam> mctStdParams = slpd0609IParam.getMctStdParams();
        String[] targets = slpd0609IParam.getTargets();
        super.validatorRequired("mctStdParams", mctStdParams);
        super.validatorRequired("targets", targets);


        for (SLPD0607IMctStdParam param : mctStdParams) {
            this.validatorRequired("mctStdId", param.getMctStdId());
            this.validatorRequired("mctStdType", param.getMctStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("mctOkVal", param.getMctOkVal(), true, 256);
            super.validatorMaxLength("mctNgVal", param.getMctNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
