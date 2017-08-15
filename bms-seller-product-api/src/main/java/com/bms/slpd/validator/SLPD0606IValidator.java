package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0606IParam;
import com.bms.slpd.bean.param.field.SLPD0601IFedStdParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 修改饲养标准标准指标Validator
 */
public class SLPD0606IValidator extends DefaultCustomValidator<SLPD0606IParam> {
    @Override
    public void validator(SLPD0606IParam request) {
        if (null == request) {
            return;
        }
        List<SLPD0601IFedStdParam> fedStdParams = request.getFedStdParams();
        String[] targets = request.getTargets();
        super.validatorRequired("fedStdParams", fedStdParams);
        super.validatorRequired("targets", targets);

        if (CollectionUtils.isNotEmpty(fedStdParams)) {
            for (SLPD0601IFedStdParam param : fedStdParams) {
                this.validatorRequired("fedStdId", param.getFedStdId());
                this.validatorRequired("fedStdType", param.getFedStdType());
                this.validatorRequired("breedId", param.getBreedId());
                super.validatorMaxLength("fedGoodVal", param.getFedGoodVal(), true, 256);
                super.validatorMaxLength("fedNormalVal", param.getFedNormalVal(), true, 256);
                super.validatorMaxLength("fedOkVal", param.getFedOkVal(), true, 256);
                super.validatorMaxLength("remark", param.getRemark(), false, 256);
            }
        }
    }
}
