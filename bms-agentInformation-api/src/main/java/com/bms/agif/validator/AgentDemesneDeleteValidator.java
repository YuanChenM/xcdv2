package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/13.
 */
public class AgentDemesneDeleteValidator extends DefaultCustomValidator<AgentDemesneParam> {

    @Override
    public void validator(AgentDemesneParam param) {
        if(param != null) {
            this.validatorLong("AGIF.L02033", param.getAgentDemesneId(), true, 9223372036854775806L, 0L, 5);
        }
    }
}
