package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0640IParam;
import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;


public class SLPD0640IValidator extends DefaultCustomValidator<SLPD0640IParam> {
    @Override
    public void validator(SLPD0640IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getSftDifStdParams())) {
            return;
        }
        List<SLPD0640ISftDifStdParam>  sftDifStdParams = request.getSftDifStdParams();
        super.validatorRequired("sftDifStdParams", sftDifStdParams);

        for (SLPD0640ISftDifStdParam param : sftDifStdParams) {
            this.validatorRequired("sftStdType", param.getSftStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("sftOkDifVal", param.getSftOkDifVal(), false, 256);
            super.validatorMaxLength("sftNgDifVal", param.getSftNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}

