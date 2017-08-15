package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0625IParam;
import com.bms.slpd.bean.param.field.SLPD0625IOrgDifStdParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0625IValidator extends DefaultCustomValidator<SLPD0625IParam> {
    @Override
    public void validator(SLPD0625IParam slpd0625IParam) {
        if (null == slpd0625IParam) {
            return;
        }
        List<SLPD0625IOrgDifStdParam> sftStdParams = slpd0625IParam.getOrgDifStdParams();
        super.validatorRequired("sftStdParams", sftStdParams);


        for (SLPD0625IOrgDifStdParam param : sftStdParams) {
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
