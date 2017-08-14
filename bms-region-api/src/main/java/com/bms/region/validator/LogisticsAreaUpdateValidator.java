package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/5.
 */
public class LogisticsAreaUpdateValidator
    extends DefaultCustomValidator<ArrayList<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>>> {

    @Override
    public void validator(
        ArrayList<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>> regnLogisticsAreaRsParamRestRequest) {
        if (!CollectionUtils.isEmpty(regnLogisticsAreaRsParamRestRequest)) {
            int count = regnLogisticsAreaRsParamRestRequest.size();
            for (int i = 0; i < count; i++) {
                this.validatorLong(i + 1, MessageDef.Label.L00010,
                    regnLogisticsAreaRsParamRestRequest.get(i).getFilter().getLgcsAreaId(), true, 9223372036854775806L,
                    0L, 5);
                if (!StringUtils.isEmpty(regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getLgcsAreaCode())) {
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00007,
                        regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getLgcsAreaCode(), true, 2);
                }
                if (!StringUtils.isEmpty(regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getLgcsAreaName())) {
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00008,
                        regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getLgcsAreaName(), true, 8);
                }
                if (!StringUtils.isEmpty(regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getDisableFlg())) {
                    this.validatorMaxLength(i + 1, MessageDef.Label.L00009,
                        regnLogisticsAreaRsParamRestRequest.get(i).getTarget().getDisableFlg(), true, 1);
                }
            }
        } else {
            this.validatorRequired(MessageDef.Error.E00011, null);
        }

    }
}
