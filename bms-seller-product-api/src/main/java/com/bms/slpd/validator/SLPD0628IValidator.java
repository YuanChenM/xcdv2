package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0628IParam;
import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增饲养标准指标差异Validator
 */
public class SLPD0628IValidator extends DefaultCustomValidator<SLPD0628IParam> {

    @Override
    public void validator(SLPD0628IParam slpd0628IParam) {
        if (null == slpd0628IParam || CollectionUtils.isEmpty(slpd0628IParam.getFedDifStdParams())) {
            return;
        }
        List<SLPD0628IFedDifStdParam> fedDifStdParams = slpd0628IParam.getFedDifStdParams();
        super.validatorRequired("fedDifStdParams", fedDifStdParams);

        for (SLPD0628IFedDifStdParam param : fedDifStdParams) {
            this.validatorRequired("fedStdType", param.getFedStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("fedGoodDifVal", param.getFedGoodDifVal(), false, 256);
            super.validatorMaxLength("fedNormalDifVal", param.getFedNormalDifVal(), false, 256);
            super.validatorMaxLength("fedOkDifVal", param.getFedOkDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
