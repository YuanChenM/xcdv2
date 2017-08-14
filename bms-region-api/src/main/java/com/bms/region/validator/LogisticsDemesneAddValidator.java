package com.bms.region.validator;

import com.bms.region.bean.param.RegnLogDemesneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsDemesneAddValidator extends DefaultCustomValidator<RegnLogDemesneParam> {

    @Override
    public void validator(RegnLogDemesneParam param) {
        if(param != null){
            this.validatorLong("REGN.L00027", param.getDistributionId(), true, 9223372036854775807L, 0L, 4);
            this.validatorRequired("REGN.L00032", param.getDemesneType());
            this.validatorMaxLength("REGN.L00034", param.getDemesneName(), true, 16);
//            this.validatorRequired("REGN.L00033", param.getDemesneCode());
        }else{
            this.validatorRequired("REGN.E00011",null);
        }
    }
}
