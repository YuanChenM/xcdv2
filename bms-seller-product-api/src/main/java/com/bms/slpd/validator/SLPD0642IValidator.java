package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0642IParam;
import com.bms.slpd.bean.param.field.SLPD0640ISftDifStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0642IValidator extends DefaultCustomValidator<SLPD0642IParam> {
    @Override
    public void validator(SLPD0642IParam request) {
        if (null == request || CollectionUtils.isEmpty(request.getSftDifStdParams())) {
            return;
        }
        List<SLPD0640ISftDifStdParam>  sftDifStdParams = request.getSftDifStdParams();
        String[] targets = request.getTargets();
        super.validatorRequired("sftDifStdParams", sftDifStdParams);
        super.validatorRequired("targets", targets);

        for (SLPD0640ISftDifStdParam param : sftDifStdParams) {
            this.validatorRequired("sftDifStdId", param.getSftDifStdId());
            this.validatorRequired("sftStdType", param.getSftStdType());
            this.validatorRequired("breedId", param.getBreedId());
            this.validatorRequired("productId", param.getProductId());
            super.validatorMaxLength("sftOkDifVal", param.getSftOkDifVal(), false, 256);
            super.validatorMaxLength("sftNgDifVal", param.getSftNgDifVal(), false, 256);
            super.validatorMaxLength("remark", param.getRemark(), false, 256);
        }
    }
}
