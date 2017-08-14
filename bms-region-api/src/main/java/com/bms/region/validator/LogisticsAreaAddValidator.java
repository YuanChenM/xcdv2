package com.bms.region.validator;

import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/1.
 */
public class LogisticsAreaAddValidator extends DefaultCustomValidator<ArrayList<LogisticsAreaRsParam>> {

    @Override
    public void validator(ArrayList<LogisticsAreaRsParam> paramRestRequest) {
        if(!CollectionUtils.isEmpty(paramRestRequest)){
            List<LogisticsAreaRsParam> param = paramRestRequest;
            int paramSize = param.size();
            for (int i = 0; i < paramSize; i++) {
                this.validatorMaxLength(i + 1, MessageDef.Label.L00007, param.get(i).getLgcsAreaCode(), true, 2);
                this.validatorMaxLength(i + 1, MessageDef.Label.L00008, param.get(i).getLgcsAreaName(), true, 8);
            }
        }else {
            this.validatorRequired(MessageDef.Error.E00011,null);
        }

    }
}
