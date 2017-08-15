package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1203IParam;
import com.bms.slpd.bean.param.field.SLPD1203ILgcsProductParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1203IValidator extends DefaultCustomValidator<SLPD1203IParam> {

    @Override
    public void validator(SLPD1203IParam slpd1203IParam) {
        List<SLPD1203ILgcsProductParam> lgcsAreaCommodities = slpd1203IParam.getLgcsCommodityParams();
        super.validatorRequired("lgcsCommodityParams", lgcsAreaCommodities);
        if (CollectionUtils.isNotEmpty(lgcsAreaCommodities)) {
            for (SLPD1203ILgcsProductParam lgcsAreaCommodity : lgcsAreaCommodities) {
                super.validatorRequired("lacId", lgcsAreaCommodity.getLacId());
                super.validatorRequired("version", lgcsAreaCommodity.getVersion());
                super.validatorMaxLength("productDemandGrade", lgcsAreaCommodity.getProductDemandGrade(), false, 1);
                super.validatorMaxLength("shelfStu", slpd1203IParam.getShelfStu(), false, 1);
            }
        }
    }

}
