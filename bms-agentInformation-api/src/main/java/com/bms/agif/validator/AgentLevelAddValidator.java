package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentLevelRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/5/15.
 */
public class AgentLevelAddValidator extends DefaultCustomValidator<AgentLevelRsParam> {
    @Override
    public void validator(AgentLevelRsParam levelRsParam) {
        if (levelRsParam != null) {
            this.validatorMaxLength("AGIF.L02012", levelRsParam.getAgentId(), true, 36);
            this.validatorMaxLength("AGIF.L02051", levelRsParam.getFrequenterAgentF(), true, 8);
            this.validatorMaxLength("AGIF.L02052", levelRsParam.getFrequenterAgentA(), true, 8);
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
