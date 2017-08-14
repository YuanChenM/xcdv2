package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentDemesneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
public class AgentDemesneAddValidator extends DefaultCustomValidator<AgentDemesneParam>{

    @Override
    public void validator(AgentDemesneParam param) {
        if(param != null){
            this.validatorLong("AGIF.L02034", param.getLgcsAreaId(), true, 9223372036854775807L, 0L, 4);
            this.validatorMaxLength("AGIF.L02035", param.getLgcsAreaCode(), true, 2);
            this.validatorMaxLength("AGIF.L02036", param.getLgcsAreaName(), true, 8);

            this.validatorMaxLength("AGIF.L02038", param.getZoneCode(), true, 3);
            this.validatorMaxLength("AGIF.L02039", param.getZoneName(), true, 8);
            this.validatorLong("AGIF.L02037", param.getZoneId(), true, 9223372036854775807L, 0L, 4);

            this.validatorRequired("AGIF.L02041", param.getDistributionType());
            this.validatorRequired("AGIF.L02043", param.getDistributionName());
            this.validatorRequired("AGIF.L02044", param.getDistributionCode());
            this.validatorLong("AGIF.L02040", param.getDistributionId(), true, 9223372036854775807L, 0L, 4);

            this.validatorRequired("AGIF.L02047", param.getDemesneType());

            this.validatorRequired("AGIF.L02049", param.getDemesneCode());

            this.validatorRequired("AGIF.L02048", param.getDemesneName());
            this.validatorLong("AGIF.L02046", param.getDemesneId(), true, 9223372036854775807L, 0L, 4);
        }else{
            this.validatorRequired("error.20002", null);
        }
    }
}
