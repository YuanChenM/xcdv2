package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0302IParam;
import com.framework.validator.DefaultCustomValidator;

public class SLPD0302IValidator extends DefaultCustomValidator<SLPD0302IParam> {
    @Override
    public void validator(SLPD0302IParam slpd0302IParam) {
        /*List<SLPD0302IItemParam> paramList = slpd0302IParam.getItemParams();
        this.validatorRequired(MessageConstant.Label.Params, paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD0302IItemParam param : paramList) {
                this.validatorRequired(MessageConstant.Label.ClassesId, param.getClassesId());
                this.validatorRequired(MessageConstant.Label.MachiningId, param.getMachiningId());
                this.validatorRequired(MessageConstant.Label.BreedId, param.getBreedId());
                this.validatorMaxLength(MessageConstant.Label.FeatureName, param.getItemName(), true, 256);
                this.validatorMaxLength(MessageConstant.Label.Specification, param.getSpecification(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.ProcessingMethod, param.getProcessingMethod(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.Taste, param.getTaste(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.CrtId, param.getCrtId(), true, 32);
            }
        }*/
    }
}
