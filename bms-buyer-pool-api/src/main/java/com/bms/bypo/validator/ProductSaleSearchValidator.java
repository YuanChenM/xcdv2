package com.bms.bypo.validator;

import com.bms.bypo.bean.param.ProductSaleRsParam;
import com.bms.bypo.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;


public class ProductSaleSearchValidator extends DefaultCustomValidator<ProductSaleRsParam> {

    @Override
    public void validator(ProductSaleRsParam param) {
        this.validatorRequired(MessageDef.Label.L00053, param.getResearchProductId());
    }
}
