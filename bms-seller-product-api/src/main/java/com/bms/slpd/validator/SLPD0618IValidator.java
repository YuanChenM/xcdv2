package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0618IParam;
import com.bms.slpd.bean.param.field.SLPD0616ISftStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0618IValidator extends DefaultCustomValidator<SLPD0618IParam> {

    @Override
    public void validator(SLPD0618IParam slpd0618IParam) {
        if (null == slpd0618IParam) {
            return;
        }
        List<SLPD0616ISftStdParam> sftStdParams = slpd0618IParam.getSftStdParams();
        String[] targets = slpd0618IParam.getTargets();
        super.validatorRequired("sftStdParams", sftStdParams);
        super.validatorRequired("targets", targets);


        for (SLPD0616ISftStdParam param : sftStdParams) {
            this.validatorRequired("sftStdId", param.getSftStdId());
            this.validatorRequired("sftStdType", param.getSftStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("sftOkVal", param.getSftOkVal(), true, 256);
            super.validatorMaxLength("sftNgVal", param.getSftNgVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
