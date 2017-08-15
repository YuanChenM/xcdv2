package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0401IParam;
import com.framework.validator.DefaultCustomValidator;

/*
 * 新增品牌所有人验证
 */
public class SLPD0401IValidator extends DefaultCustomValidator<SLPD0401IParam> {
    @Override
    public void validator(SLPD0401IParam result) {
        /*List<SlpdBrand> slpd0401IParamList = result.getBeans();


        this.validatorRequired(MessageConstant.Label.Beans, slpd0401IParamList);


        for (SlpdBrand slpd : slpd0401IParamList) {
            this.validatorMaxLength(MessageConstant.Label.BrandName, slpd.getBrandName(), true, 256);
            this.validatorMaxLength(MessageConstant.Label.UpdId, slpd.getUpdId(), true, 32);
//            this.validatorMaxLength(MessageConstant.Label.BrandIType, slpd.getBrandType(), true, 1);
            this.validatorMaxLength(MessageConstant.Label.CrtId, slpd.getCrtId(), true, 32);
            this.validatorDate(MessageConstant.Label.UpdTime, slpd.getUpdTime(), false);
            this.validatorDate(MessageConstant.Label.CrtTime, slpd.getCrtTime(), false);

        }*/

    }
}
