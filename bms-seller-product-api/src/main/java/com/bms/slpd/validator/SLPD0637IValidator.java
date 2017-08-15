package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0637IParam;
import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增通用质量标准指标差异Validator
 */
public class SLPD0637IValidator extends DefaultCustomValidator<SLPD0637IParam> {

    @Override
    public void validator(SLPD0637IParam slpd0637IParam) {
        if (null == slpd0637IParam || CollectionUtils.isEmpty(slpd0637IParam.getGnqDifStdParams())) {
            return;
        }
        List<SLPD0637IGnqDifStdParam>  gnqDifStdParams = slpd0637IParam.getGnqDifStdParams();
        super.validatorRequired("gnqDifStdParams", gnqDifStdParams);

        for (SLPD0637IGnqDifStdParam param : gnqDifStdParams) {
            this.validatorRequired("gnqStdType", param.getGnqStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("gnqOkDifVal", param.getGnqOkDifVal(), false, 256);
            super.validatorMaxLength("gnqNgDifVal", param.getGnqNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
