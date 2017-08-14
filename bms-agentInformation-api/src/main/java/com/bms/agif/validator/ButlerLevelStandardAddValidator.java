package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerLevelStandardPageParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhao_chen on 2017/3/9.
 */
public class ButlerLevelStandardAddValidator extends DefaultCustomValidator<ArrayList<ButlerLevelStandardPageParam>> {
    @Override
    public void validator(ArrayList<ButlerLevelStandardPageParam> paramArrayList) {
        if (CollectionUtils.isNotEmpty(paramArrayList)) {
            for (int i = 0; i < paramArrayList.size(); i++) {
                ButlerLevelStandardPageParam param = paramArrayList.get(i);
                this.validatorLong("AGIF.L02034", param.getLgcsAreaId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02035", param.getLgcsAreaCode(), true, 2);
                this.validatorMaxLength("AGIF.L02036", param.getLgcsAreaName(), true, 8);
                this.validatorMaxLength("AGIF.L02009", param.getLevelName(), true, 8);

                this.validatorDecimal("AGIF.L06001", param.getLevelValue(), false, 2, 1, 5);
                this.validatorDecimal("AGIF.L06003", param.getMonthAverageSales(), false, 15, 2, 7);
                this.validatorDecimal("AGIF.L06004", param.getMonthAverageGrossProfit(), false, 15, 2, 7);
                this.validatorDecimal("AGIF.L06005", param.getMonthAverageNetProfit(), false, 15, 2, 7);
            }
        } else {
            this.validatorRequired("AGIF.E06001", null);
        }
    }
}
