package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD030301IParam;
import com.bms.slpd.bean.param.SLPD0303IParam;
import com.bms.slpd.constant.MessageConstant;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0303IValidator extends DefaultCustomValidator<SLPD0303IParam> {
    @Override
    public void validator(SLPD0303IParam slpd0303IParam) {
        /*List<SLPD030301IParam> paramList = slpd0303IParam.getUpdItemParams();
        this.validatorRequired(MessageConstant.Label.Params, paramList);
        this.validatorRequired(MessageConstant.Label.Targets, slpd0303IParam.getTargets());
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD030301IParam param : paramList) {
                this.validatorRequired(MessageConstant.Label.FeatureId, param.getItemId());
                this.validatorMaxLength(MessageConstant.Label.FeatureName, param.getItemName(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.Specification, param.getSpecification(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.ProcessingMethod, param.getProcessingMethod(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.Taste, param.getTaste(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.UpdId, param.getUpdId(), true, 32);
                this.validatorRequired(MessageConstant.Label.Version, param.getVersion());
            }
        }*/
    }
}
