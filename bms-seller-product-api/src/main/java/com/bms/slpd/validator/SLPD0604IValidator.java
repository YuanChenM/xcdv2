package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0604IParam;
import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增饲养标准指标Validator
 */
public class SLPD0604IValidator extends DefaultCustomValidator<SLPD0604IParam> {
    @Override
    public void validator(SLPD0604IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getFedStdParams())) {
            return;
        }
        List<SLPD0601IFedStdParam> fedStdParams = request.getFedStdParams();
        super.validatorRequired("fedStdParams", fedStdParams);


        for (SLPD0601IFedStdParam param : fedStdParams) {
            this.validatorRequired("fedStdType", param.getFedStdType());
            this.validatorRequired("breedId", param.getBreedId());
            super.validatorMaxLength("fedGoodVal", param.getFedGoodVal(), true, 256);
            super.validatorMaxLength("fedNormalVal", param.getFedNormalVal(), true, 256);
            super.validatorMaxLength("fedOkVal", param.getFedOkVal(), true, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}

