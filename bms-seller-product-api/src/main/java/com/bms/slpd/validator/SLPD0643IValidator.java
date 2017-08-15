package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0643IParam;
import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0643IValidator extends DefaultCustomValidator<SLPD0643IParam> {
    @Override
    public void validator(SLPD0643IParam slpd0643IParam) {
        if (null == slpd0643IParam || CollectionUtils.isEmpty(slpd0643IParam.getTspDifStdParams())) {
            return;
        }
        List<SLPD0643ITspDifStdParam>  sftDifStdParams = slpd0643IParam.getTspDifStdParams();
        super.validatorRequired("sftDifStdParams", sftDifStdParams);

        for (SLPD0643ITspDifStdParam param : sftDifStdParams) {
            this.validatorRequired("tspStdType", param.getTspStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("tspOkDifVal", param.getTspOkDifVal(), false, 256);
            super.validatorMaxLength("tspNgDifVal", param.getTspNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
