package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0636IParam;
import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0636IValidator extends DefaultCustomValidator<SLPD0636IParam> {

    @Override
    public void validator(SLPD0636IParam slpd0636IParam) {
        if (null == slpd0636IParam || CollectionUtils.isEmpty(slpd0636IParam.getTncDifStdParams())) {
            return;
        }
        List<SLPD0634ITncDifStdParam> tncDifStdParams = slpd0636IParam.getTncDifStdParams();
        String[] targets = slpd0636IParam.getTargets();
        super.validatorRequired("tncDifStdParams", tncDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0634ITncDifStdParam param : tncDifStdParams) {
            this.validatorRequired("tncDifStdId", param.getTncDifStdId());
            this.validatorRequired("tncStdType", param.getTncStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("tncStdDifValA", param.getTncStdDifValA(), false, 256);
            super.validatorMaxLength("tncStdDifValB", param.getTncStdDifValB(), false, 256);
            super.validatorMaxLength("tncStdDifValC", param.getTncStdDifValC(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
