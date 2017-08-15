package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0630IParam;
import com.bms.slpd.bean.param.field.SLPD0628IFedDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改饲养标准指标差异Validator
 */
public class SLPD0630IValidator extends DefaultCustomValidator<SLPD0630IParam> {

    @Override
    public void validator(SLPD0630IParam slpd0630IParam) {
        if (null == slpd0630IParam || CollectionUtils.isEmpty(slpd0630IParam.getFedDifStdParams())) {
            return;
        }
        List<SLPD0628IFedDifStdParam> fedDifStdParams = slpd0630IParam.getFedDifStdParams();
        String[] targets = slpd0630IParam.getTargets();
        super.validatorRequired("fedDifStdParams", fedDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0628IFedDifStdParam param : fedDifStdParams) {
            this.validatorRequired("fedDifStdId", param.getFedDifStdId());
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
