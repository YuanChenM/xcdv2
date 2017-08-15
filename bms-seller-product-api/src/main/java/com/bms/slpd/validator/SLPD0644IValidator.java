package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0644IParam;
import com.bms.slpd.bean.param.field.SLPD0643ITspDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


public class SLPD0644IValidator extends DefaultCustomValidator<SLPD0644IParam> {
    @Override
    public void validator(SLPD0644IParam slpd0644IParam) {
        if (null == slpd0644IParam || CollectionUtils.isEmpty(slpd0644IParam.getTspDifStdParams())) {
            return;
        }
        List<SLPD0643ITspDifStdParam>  sftDifStdParams = slpd0644IParam.getTspDifStdParams();
        String[] targets = slpd0644IParam.getTargets();
        super.validatorRequired("sftDifStdParams", sftDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0643ITspDifStdParam param : sftDifStdParams) {
            this.validatorRequired("tspDifStdId", param.getTspDifStdId());
            this.validatorRequired("tspStdType", param.getTspStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("tspOkDifVal", param.getTspOkDifVal(), false, 256);
            super.validatorMaxLength("tspNgDifVal", param.getTspNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
