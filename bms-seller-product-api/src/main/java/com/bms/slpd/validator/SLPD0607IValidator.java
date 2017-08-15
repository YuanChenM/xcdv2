package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0607IParam;
import com.bms.slpd.bean.param.field.SLPD0607IMctStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0607IValidator extends DefaultCustomValidator<SLPD0607IParam> {
    @Override
    public void validator(SLPD0607IParam slpd0607IParam) {
        if (null == slpd0607IParam || CollectionUtils.isEmpty(slpd0607IParam.getMctStdParams())) {
            return;
        }
        List<SLPD0607IMctStdParam> orgStdParams = slpd0607IParam.getMctStdParams();
        super.validatorRequired("mctStdParams", orgStdParams);

        for (SLPD0607IMctStdParam param : orgStdParams) {
            this.validatorRequired("mctStdType", param.getMctStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("mctOkVal", param.getMctOkVal(), true, 256);
            super.validatorMaxLength("mctNgVal", param.getMctNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
