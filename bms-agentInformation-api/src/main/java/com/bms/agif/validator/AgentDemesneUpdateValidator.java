package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.bms.agif.bean.param.BaseBean;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
public class AgentDemesneUpdateValidator extends DefaultCustomValidator<BaseBean<AgentDemesneParam, AgentDemesneParam>>{

    @Override
    public void validator(BaseBean<AgentDemesneParam, AgentDemesneParam> param) {
        if(param != null){
            this.validatorLong("AGIF.L02033",param.getFilter().getAgentDemesneId(), true, 9223372036854775806L,0L, 5);
            if(param.getTarget().getDelFlg() != null && param.getTarget().getDelFlg() == false){
                this.validatorLong("AGIF.L02034", param.getTarget().getLgcsAreaId(), true, 9223372036854775807L, 0L, 4);
                this.validatorMaxLength("AGIF.L02035", param.getTarget().getLgcsAreaCode(), true, 2);
                this.validatorMaxLength("AGIF.L02036", param.getTarget().getLgcsAreaName(), true, 8);

                this.validatorMaxLength("AGIF.L02038", param.getTarget().getZoneCode(), true, 3);
                this.validatorMaxLength("AGIF.L02039", param.getTarget().getZoneName(), true, 8);
                this.validatorLong("AGIF.L02037", param.getTarget().getZoneId(), true, 9223372036854775807L, 0L, 4);

                this.validatorRequired("AGIF.L02041", param.getTarget().getDistributionType());
                this.validatorRequired("AGIF.L02043", param.getTarget().getDistributionName());
                this.validatorRequired("AGIF.L02044", param.getTarget().getDistributionCode());
                this.validatorRequired("AGIF.L02045", param.getTarget().getAuthorizedPartner());
                this.validatorLong("AGIF.L02040", param.getTarget().getDistributionId(), true, 9223372036854775807L, 0L, 4);

                this.validatorRequired("AGIF.L02047", param.getTarget().getDemesneType());
                this.validatorRequired("AGIF.L02049", param.getTarget().getDemesneCode());
                this.validatorRequired("AGIF.L02048", param.getTarget().getDemesneName());
                this.validatorRequired("AGIF.L02050", param.getTarget().getAuthorizedAgent());
                this.validatorLong("AGIF.L02046", param.getTarget().getDemesneId(), true, 9223372036854775807L, 0L, 4);
            }
        }else{
            this.validatorRequired("error.20002", null);
        }
    }



}
