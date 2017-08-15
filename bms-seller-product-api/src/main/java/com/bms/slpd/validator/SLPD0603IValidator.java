
package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0603IParam;
import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


/**
 * 修改原种种源标准指标Validator
 */


public class SLPD0603IValidator extends DefaultCustomValidator<SLPD0603IParam> {

    @Override
    public void validator(SLPD0603IParam slpd0603IParam) {
        if (null == slpd0603IParam || CollectionUtils.isEmpty(slpd0603IParam.getOrgStdParams())) {
            return;
        }
        List<SLPD0601IOrgStdParam> orgStdParams = slpd0603IParam.getOrgStdParams();
        super.validatorRequired("orgStdParams", orgStdParams);

        for (SLPD0601IOrgStdParam param : orgStdParams) {
            this.validatorRequired("orgStdId", param.getOrgStdId());
            this.validatorRequired("orgStdType", param.getOrgStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("orgGoodVal", param.getOrgGoodVal(), true, 256);
            super.validatorMaxLength("orgNormalVal", param.getOrgNormalVal(), true, 256);
            super.validatorMaxLength("orgOkVal", param.getOrgOkVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}


