package com.bms.region.validator;

import com.bms.region.bean.param.DistrictRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhao_chen on 2016/12/2.
 */
public class DistrictSearchValidator extends DefaultCustomValidator<DistrictRsParam> {
    @Override
    public void validator(DistrictRsParam param) {
        if (param!= null) {
            if(param.getCityId() != null || param.getCityCode() != null || param.getCityName() != null){
                if(param.getCityId() != null){
                    this.validatorLong(MessageDef.Label.L00019, param.getCityId(), true, 9223372036854775807L, 0L, 4);
                }else if(param.getCityCode() != null){
                    this.validatorRequired(MessageDef.Label.L00019, param.getCityCode());
                }else if(param.getCityName() != null){
                    this.validatorRequired(MessageDef.Label.L00019, param.getCityName());
                }
            }
        } else {
            this.validatorRequired(MessageDef.Error.E00011, null);
        }
    }
}
