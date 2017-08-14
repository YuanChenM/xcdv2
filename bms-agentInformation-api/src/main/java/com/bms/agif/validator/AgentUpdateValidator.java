package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentParam;
import com.bms.agif.bean.param.BaseBean;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
public class AgentUpdateValidator extends DefaultCustomValidator<BaseBean<AgentParam, AgentParam>>{

    @Override
    public void validator(BaseBean<AgentParam, AgentParam> param) {
        if(param != null){
            if(param.getTarget().getDelFlg() == null){
                param.getTarget().setDelFlg(false);
            }
            if(!StringUtils.isEmpty(param.getFilter().getAgentId())){
                this.validatorRequired("AGIF.L02012", param.getFilter().getAgentId());
            }
            if(!StringUtils.isEmpty(param.getFilter().getAgentCode())){
                this.validatorRequired("AGIF.L02006", param.getFilter().getAgentCode());
            }
            if(param.getTarget().getDelFlg() != null && !param.getTarget().getDelFlg()){
                this.validatorRequired("AGIF.L02007", param.getTarget().getCategoryCode());
                this.validatorRequired("AGIF.L02008", param.getTarget().getCategoryName());
                this.validatorRequired("AGIF.L02005", param.getTarget().getAgentName());
            }
        }else{
            this.validatorRequired("error.20002", null);
        }
    }
}
