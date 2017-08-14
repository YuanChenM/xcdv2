package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentRelationRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/4/10.
 */
public class AgentRelationSearchValidator extends DefaultCustomValidator<AgentRelationRsParam> {
    @Override
    public void validator(AgentRelationRsParam rsParam) {
        if (rsParam != null) {
            this.validatorRequired("AGIF.L03043", rsParam.getAgentId());
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
