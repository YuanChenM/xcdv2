package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1810IParam;
import com.bms.slpd.bean.param.field.SLPD1810IAgentSupplyProductParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1810IValidator extends DefaultCustomValidator<SLPD1810IParam> {

    @Override
    public void validator(SLPD1810IParam slpd1810IParam) {
        List<SLPD1810IAgentSupplyProductParam> agentSupplyProductParams = slpd1810IParam.getAgentSupplyProductParams();
        super.validatorRequired("agentSupplyProductParams", agentSupplyProductParams);
        if (CollectionUtils.isNotEmpty(agentSupplyProductParams)) {
            for (SLPD1810IAgentSupplyProductParam param : agentSupplyProductParams) {
                super.validatorRequired("manufacturerProductId", param.getManufacturerProductId());
                super.validatorRequired("productId", param.getProductId());
                super.validatorRequired("entitySellerId", param.getEntitySellerId());
            }
        }
    }

}
