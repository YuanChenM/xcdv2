package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1816IParam;
import com.bms.slpd.bean.param.field.SLPD1816IProductParam;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * 新增产品Validator
 */
public class SLPD1816IValidator extends DefaultCustomValidator<SLPD1816IParam> {

    @Override
    public void validator(SLPD1816IParam slpd1816IParam) {
        List<SLPD1816IProductParam> paramList = slpd1816IParam.getProductParams();
        this.validatorRequired("products", paramList);

        for (SLPD1816IProductParam product : paramList) {
            this.validatorMaxLength("qualityGradeType", product.getQualityGradeType(), true, 1);
            this.validatorDecimal("netWeight", product.getNetWeight(), true, 12,2,5);
            this.validatorLong("itemPropertyId", product.getItemPropertyId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorLong("itemId", product.getItemId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
            this.validatorLong("brandId", product.getBrandId(), true, Long.MAX_VALUE, Long.MIN_VALUE, 4);
        }
    }

}
