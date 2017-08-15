package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0504IParam;
import com.bms.slpd.bean.param.field.SLPD0504IItemPropertyParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0504IValidator extends DefaultCustomValidator<SLPD0504IParam> {
    @Override
    public void validator(SLPD0504IParam slpd0504IParam) {
        List<SLPD0504IItemPropertyParam> paramList = slpd0504IParam.getItemProperties();
        this.validatorRequired("itemProperties", paramList);

        for (SLPD0504IItemPropertyParam slpd : paramList) {
//            this.validatorInteger("cartonHeight", slpd.getCartonHeight(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
//            this.validatorInteger("cartonWidth", slpd.getCartonWidth(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
//            this.validatorInteger("cartonLength", slpd.getCartonLength(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            this.validatorMaxLength("cartonDimension", slpd.getCartonDimension(), false, 256);
            this.validatorMaxLength("packageSpecification", slpd.getPackageSpecification(), true, 256);
            this.validatorInteger("packageQuantity", slpd.getPackageQuantity(), true,Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            this.validatorMaxLength("sourceType", slpd.getSourceType(), true, 1);

            this.validatorInteger("palletStackingLimit", slpd.getPalletStackingLimit(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            this.validatorDecimal("grossWeight", slpd.getGrossWeight(), true, 12,2, 5);
            this.validatorLong("itemId", slpd.getItemId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
        }
    }
}

