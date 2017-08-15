package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0402IParam;
import com.framework.validator.DefaultCustomValidator;

/*
 * 修改品牌所有人验证
 */
public class SLPD0402IValidator extends DefaultCustomValidator<SLPD0402IParam> {
    @Override
    public void validator(SLPD0402IParam result) {
        /*List<SLPD0402IParam> slpd0402IParamList = result.getBeans();

        this.validatorRequired(MessageConstant.Label.Beans, slpd0402IParamList);
        this.validatorRequired(MessageConstant.Label.Targets, result.getTargets());


        if (CollectionUtils.isNotEmpty(slpd0402IParamList)) {
            for (SLPD0402IParam slpd : slpd0402IParamList) {
                this.validatorMaxLength(MessageConstant.Label.BrandName, slpd.getBrandName(), false, 256);
                this.validatorMaxLength(MessageConstant.Label.BrandIType, slpd.getBrandType(), false, 1);
                this.validatorMaxLength(MessageConstant.Label.UpdId, slpd.getUpdId(), true, 32);
                this.validatorDate(MessageConstant.Label.UpdTime, slpd.getUpdTime(), false);
                this.validatorInteger(MessageConstant.Label.Version, slpd.getVersion(), true, Integer.MAX_VALUE, Integer.MIN_VALUE, 4);
            }
        }*/
    }
}
