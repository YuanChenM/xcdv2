package com.bms.region.validator;

import com.bms.region.bean.param.RegnLogisticsZoneParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2017/2/21.
 */
public class LogisticsZoneAddValidator extends DefaultCustomValidator<RegnLogisticsZoneParam> {

    @Override
    public void validator(RegnLogisticsZoneParam logisticsCityParam) {
        if(logisticsCityParam != null){
            this.validatorLong("REGN.L00010", logisticsCityParam.getLgcsAreaId(), true, 9223372036854775807L, 0L, 4);
            this.validatorMaxLength("REGN.L00025", logisticsCityParam.getZoneCode(), true, 3);
            this.validatorMaxLength("REGN.L00026", logisticsCityParam.getZoneName(), true, 8);
        }else{
            this.validatorRequired("REGN.E00011",null);
        }
    }
}
