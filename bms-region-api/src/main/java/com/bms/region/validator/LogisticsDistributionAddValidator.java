package com.bms.region.validator;

import com.bms.region.bean.param.RegnLogDistributionParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsDistributionAddValidator extends DefaultCustomValidator<RegnLogDistributionParam> {

    @Override
    public void validator(RegnLogDistributionParam param) {
        if(param != null){
            this.validatorLong("REGN.L00024", param.getZoneId(), true, 9223372036854775807L, 0L, 4);
            this.validatorRequired("REGN.L00028", param.getDistributionType());
            this.validatorRequired("REGN.L00030", param.getDistributionName());
//            this.validatorRequired("REGN.L00033", param.getDistributionCode());
        }else{
            this.validatorRequired("REGN.E00011",null);
        }
    }
}
