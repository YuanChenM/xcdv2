package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1811IAgentProductParam;
import com.bms.slpd.bean.param.SLPD1811IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1811IValidator extends DefaultCustomValidator<SLPD1811IParam> {

    @Override
    public void validator(SLPD1811IParam slpd1811IParam) {
        List<SLPD1811IAgentProductParam> paramList = slpd1811IParam.getAgentProductParams();
        this.validatorRequired("agentProductParams", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD1811IAgentProductParam param : paramList) {
                this.validatorRequired("asProductId", param.getAsProductId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
