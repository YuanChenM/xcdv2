package com.bms.region.validator;

import com.bms.region.bean.param.StreetRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2016/12/1.
 */
public class StreetSaveValidator extends DefaultCustomValidator<ArrayList<StreetRsParam>> {
    @Override
    public void validator(ArrayList<StreetRsParam> streetParams) {
        StreetRsParam param = null;
        if (CollectionUtils.isNotEmpty(streetParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < streetParams.size(); i++) {
                param = streetParams.get(i);
                this.validatorLong(MessageDef.Label.L00022, param.getDistrictId(), true, 9223372036854775807L, 0L, 5);
                this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00014, param.getStreetCode(), true, 3);
                this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00015, param.getStreetName(), true, 9);
            }
        } else {
            this.validatorRequired(MessageDef.Error.E00011, null);
        }
    }
}
