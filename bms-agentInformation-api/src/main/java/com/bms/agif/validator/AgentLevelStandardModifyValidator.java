package com.bms.agif.validator;

import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/3/21.
 */
public class AgentLevelStandardModifyValidator extends DefaultCustomValidator<ArrayList<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (int i = 0; i < params.size(); i++) {
                BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam> param = params.get(i);
                AgentLevelStandardPageParam target = param.getTarget();
                AgentLevelStandardPageParam filter = param.getFilter();
                this.validatorLong("AGIF.L06006", filter.getLevelId(), true, Long.MAX_VALUE, 0L, 4);
                this.validatorMaxLength("AGIF.L02035", target.getLgcsAreaCode(), false, 2);
                this.validatorMaxLength("AGIF.L02036", target.getLgcsAreaName(), false, 8);
                this.validatorMaxLength("AGIF.L02009", target.getLevelName(), false, 8);

                this.validatorInteger("AGIF.L05001", target.getFrequencyTotal(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05002", target.getFrequency1(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05003", target.getFrequency2(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05004", target.getFrequency3(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05005", target.getFrequency4(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05006", target.getAmountTotal(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05007", target.getAmount1(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05008", target.getAmount2(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L05009", target.getAmount3(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
                this.validatorInteger("AGIF.L050010", target.getAmount4(), false, Integer.MAX_VALUE, Integer.MIN_VALUE, 5);
            }
        } else {
            this.validatorRequired("AGIF.E06001", null);
        }
    }
}
