package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0634IParam;
import com.bms.slpd.bean.param.field.SLPD0634ITncDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0634IValidator extends DefaultCustomValidator<SLPD0634IParam> {

    @Override
    public void validator(SLPD0634IParam slpd0634IParam) {
        if (null == slpd0634IParam || CollectionUtils.isEmpty(slpd0634IParam.getTncDifStdParams())) {
            return;
        }
        List<SLPD0634ITncDifStdParam> tncDifStdParams = slpd0634IParam.getTncDifStdParams();
        super.validatorRequired("tncDifStdParams", tncDifStdParams);

        for (SLPD0634ITncDifStdParam param : tncDifStdParams) {
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
