package com.bms.region.validator;

import com.bms.region.bean.param.DistrictRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhao_chen on 2016/12/2.
 */
public class DistrictAddValidator extends DefaultCustomValidator<ArrayList<DistrictRsParam>> {
    @Override
    public void validator(ArrayList<DistrictRsParam> paramList) {
        if (paramList != null) {
            HashSet set = new HashSet();
            int size = paramList.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    this.validatorLong(MessageDef.Label.L00022, paramList.get(i).getCityId(), true, 9223372036854775807L, 0L, 4);
                    this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00020, paramList.get(i).getDistrictCode(), true, 2);
                    this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00021, paramList.get(i).getDistrictName(), true, 8);
                    String code = paramList.get(i).getCityId() + paramList.get(i).getDistrictCode();
                    if (set.contains(code)) {
                        this.validatorRequired(MessageDef.Error.E00012, null);
                    } else {
                        set.add(code);
                    }
                }
            } else {
                this.validatorRequired(MessageDef.Error.E00011, null);
            }

        }
    }
}
