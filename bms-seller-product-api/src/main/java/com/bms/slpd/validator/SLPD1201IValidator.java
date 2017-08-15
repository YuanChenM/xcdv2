package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1201IParam;
import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1201IValidator extends DefaultCustomValidator<SLPD1201IParam> {

    @Override
    public void validator(SLPD1201IParam slpd1201IParam) {
        List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities = slpd1201IParam.getLgcsAreaCommodities();
        super.validatorRequired("lgcsAreaProducts", lgcsAreaCommodities);
        if (CollectionUtils.isNotEmpty(lgcsAreaCommodities)) {
            for (SLPD1201ILgcsAreaProduct lgcsAreaCommodity : lgcsAreaCommodities) {
                super.validatorRequired("lgcsAreaId", lgcsAreaCommodity.getLgcsAreaId());
                super.validatorRequired("lgcsAreaCode", lgcsAreaCommodity.getLgcsAreaCode());
                super.validatorRequired("lgcsAreaName", lgcsAreaCommodity.getLgcsAreaName());
                super.validatorRequired("productId", lgcsAreaCommodity.getProductId());
                super.validatorRequired("productDemandGrade", lgcsAreaCommodity.getProductDemandGrade());
            }
        }
    }

}
