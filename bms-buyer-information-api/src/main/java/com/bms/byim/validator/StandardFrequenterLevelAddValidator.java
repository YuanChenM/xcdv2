package com.bms.byim.validator;

import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * @param
 * @author zhao_chen
 */
public class StandardFrequenterLevelAddValidator extends DefaultCustomValidator<ArrayList<StandardFrequenterLevelRsParam>> {
    @Override
    public void validator(ArrayList<StandardFrequenterLevelRsParam> result) {
        int size = result.size();
        StandardFrequenterLevelRsParam param;
        if (size > NumberConst.IntDef.INT_ZERO) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                param = result.get(i);

            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }

    }
}
