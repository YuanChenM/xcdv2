package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0631IParam;
import com.bms.slpd.bean.param.field.SLPD0631IMctDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


public class SLPD0631IValidator extends DefaultCustomValidator<SLPD0631IParam> {
    @Override
    public void validator(SLPD0631IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getMctDifStdParams())) {
            return;
        }
        List<SLPD0631IMctDifStdParam> mctDifStdParams = request.getMctDifStdParams();
        super.validatorRequired("mctDifStdParams", mctDifStdParams);

        for (SLPD0631IMctDifStdParam param : mctDifStdParams) {
            this.validatorRequired("mctStdType", param.getMctStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("mctOkDifVal", param.getMctOkDifVal(), false, 256);
            super.validatorMaxLength("mctNgDifVal", param.getMctNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}

