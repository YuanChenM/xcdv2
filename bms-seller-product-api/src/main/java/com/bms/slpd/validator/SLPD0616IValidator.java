package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0616IParam;
import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0616IValidator extends DefaultCustomValidator<SLPD0616IParam> {
    @Override
    public void validator(SLPD0616IParam slpd0616IParam) {
        if (null == slpd0616IParam) {
            return;
        }
        List<SLPD0616ISftStdParam> sftStdParams = slpd0616IParam.getSftStdParams();
        super.validatorRequired("sftStdParams", sftStdParams);


        for (SLPD0616ISftStdParam param : sftStdParams) {
            this.validatorRequired("sftStdType", param.getSftStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("sftOkVal", param.getSftOkVal(), true, 256);
            super.validatorMaxLength("sftNgVal", param.getSftNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
