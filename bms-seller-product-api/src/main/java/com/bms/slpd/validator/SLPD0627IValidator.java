package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0627IParam;
import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0627IValidator extends DefaultCustomValidator<SLPD0627IParam> {

    @Override
    public void validator(SLPD0627IParam slpd0627IParam) {
        if (null == slpd0627IParam) {
            return;
        }
        List<SLPD0625IOrgDifStdParam> sftStdParams = slpd0627IParam.getOrgDifStdParams();
        String[] targets = slpd0627IParam.getTargets();
        super.validatorRequired("sftStdParams", sftStdParams);
        super.validatorRequired("targets", targets);


        for (SLPD0625IOrgDifStdParam param : sftStdParams) {
            this.validatorRequired("orgDifStdId", param.getOrgDifStdId());
            this.validatorRequired("sftStdType", param.getOrgStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("orgGoodDifVal", param.getOrgGoodDifVal(), false, 256);
            super.validatorMaxLength("orgNormalDifVal", param.getOrgNormalDifVal(), false, 256);
            super.validatorMaxLength("orgOkDifVal", param.getOrgOkDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
