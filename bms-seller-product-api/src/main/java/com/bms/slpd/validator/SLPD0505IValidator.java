package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0505IParam;
import com.framework.validator.DefaultCustomValidator;


public class SLPD0505IValidator extends DefaultCustomValidator<SLPD0505IParam> {
    @Override
    public void validator(SLPD0505IParam slpd0505IParam) {
        /*List<SlpdBrandItemPropertyParam> paramList = slpd0505IParam.getBrandItemProperties();
        this.validatorRequired(MessageConstant.Label.Beans, paramList);
        this.validatorRequired(MessageConstant.Label.Targets, slpd0505IParam.getTargets());

        for (SlpdBrandItemPropertyParam slpd : paramList) {
            this.validatorLong(MessageConstant.Label.BrandItemPropertyId, slpd.getBrandItemPropertyId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorMaxLength(MessageConstant.Label.SourceType, slpd.getSourceType(), false, 1);
            this.validatorMaxLength(MessageConstant.Label.QualityGradeType, slpd.getQualityGradeType(), false, 1);
            this.validatorDecimal(MessageConstant.Label.GrossWeight, slpd.getGrossWeight(), false, 12,2, 5);
            this.validatorDecimal(MessageConstant.Label.NetWeight, slpd.getNetWeight(), false, 12, 2, 5);
            this.validatorMaxLength(MessageConstant.Label.CartonDimension, slpd.getCartonDimension(), false, 256);
            this.validatorMaxLength(MessageConstant.Label.PackageSpecification, slpd.getPackageSpecification(), false, 256);
            this.validatorInteger(MessageConstant.Label.PackageQuantity, slpd.getPackageQuantity(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            this.validatorInteger(MessageConstant.Label.PalletStackingLimit, slpd.getPalletStackingLimit(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            this.validatorDate(MessageConstant.Label.UpdTime, slpd.getUpdTime(), false);
            this.validatorMaxLength(MessageConstant.Label.UpdId, slpd.getUpdId(), true, 32);

        }*/
    }
}

