package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhao_chen on 2017/3/9.
 */
public class AgentLevelStandardAddValidator extends DefaultCustomValidator<ArrayList<AgentLevelStandardPageParam>> {
    @Override
    public void validator(ArrayList<AgentLevelStandardPageParam> paramArrayList) {
        if (CollectionUtils.isNotEmpty(paramArrayList)) {
            for (int i = 0; i < paramArrayList.size(); i++) {
                AgentLevelStandardPageParam param = paramArrayList.get(i);
                this.validatorLong("AGIF.L02034", param.getLgcsAreaId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02035", param.getLgcsAreaCode(), true, 2);
                this.validatorMaxLength("AGIF.L02036", param.getLgcsAreaName(), true, 8);
                this.validatorMaxLength("AGIF.L02009", param.getLevelName(), true, 8);

                this.validatorInteger("AGIF.L05001", param.getFrequencyTotal(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05002", param.getFrequency1(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05003", param.getFrequency2(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05004", param.getFrequency3(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05005", param.getFrequency4(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05006", param.getAmountTotal(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05007", param.getAmount1(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05008", param.getAmount2(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05009", param.getAmount3(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L050010", param.getAmount4(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            }
        } else {
            this.validatorRequired("AGIF.E05001", null);
        }
    }
}
