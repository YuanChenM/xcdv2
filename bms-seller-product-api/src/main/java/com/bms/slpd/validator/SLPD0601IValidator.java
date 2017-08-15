
package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0601IParam;
import com.bms.slpd.bean.param.field.SLPD0601IOrgStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


/**
 * 新增原种种源标准指标Validator
 */


public class SLPD0601IValidator extends DefaultCustomValidator<SLPD0601IParam> {

    @Override
    public void validator(SLPD0601IParam slpd0601IParam) {
        if (null == slpd0601IParam || CollectionUtils.isEmpty(slpd0601IParam.getOrgStdParams())) {
            return;
        }
        List<SLPD0601IOrgStdParam> orgStdParams = slpd0601IParam.getOrgStdParams();
        super.validatorRequired("orgStdParams", orgStdParams);

        for (SLPD0601IOrgStdParam param : orgStdParams) {
            this.validatorRequired("orgStdType", param.getOrgStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("orgGoodVal", param.getOrgGoodVal(), true, 256);
            super.validatorMaxLength("orgNormalVal", param.getOrgNormalVal(), true, 256);
            super.validatorMaxLength("orgOkVal", param.getOrgOkVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}


