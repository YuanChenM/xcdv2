package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0639IParam;
import com.bms.slpd.bean.param.field.SLPD0637IGnqDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改通用质量标准指标差异Validator
 */
public class SLPD0639IValidator extends DefaultCustomValidator<SLPD0639IParam> {

    @Override
    public void validator(SLPD0639IParam slpd0639IParam) {
        if (null == slpd0639IParam || CollectionUtils.isEmpty(slpd0639IParam.getGnqDifStdParams())) {
            return;
        }
        List<SLPD0637IGnqDifStdParam> gnqDifStdParams = slpd0639IParam.getGnqDifStdParams();
        String[] targets = slpd0639IParam.getTargets();
        super.validatorRequired("gnqDifStdParams", gnqDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0637IGnqDifStdParam param : gnqDifStdParams) {
            this.validatorRequired("gnqDifStdId", param.getGnqDifStdId());
            this.validatorRequired("gnqStdType", param.getGnqStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("gnqOkDifVal", param.getGnqOkDifVal(), false, 256);
            super.validatorMaxLength("gnqNgDifVal", param.getGnqNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
