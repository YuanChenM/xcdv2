package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
public class AgentAddValidator extends DefaultCustomValidator<AgentParam>{

    @Override
    public void validator(AgentParam param) {
        if(param != null){
            this.validatorRequired("AGIF.L02007", param.getCategoryCode());
            this.validatorRequired("AGIF.L02008", param.getCategoryName());
            this.validatorRequired("AGIF.L02005", param.getAgentName());
        }else{
            this.validatorRequired("error.20002", null);
        }
    }
}
