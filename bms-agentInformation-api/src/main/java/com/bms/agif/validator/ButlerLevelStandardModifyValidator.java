package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerLevelStandardPageParam;
import com.bms.agif.bean.param.PartnerAccountRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/21.
 */
public class ButlerLevelStandardModifyValidator extends DefaultCustomValidator<ArrayList<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            for (int i=0;i<params.size();i++){
                BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam> param = params.get(i);
                ButlerLevelStandardPageParam target = param.getTarget();
                ButlerLevelStandardPageParam filter =param.getFilter();

                this.validatorLong("AGIF.L06006", filter.getLevelId(), true, Long.MAX_VALUE, 0L, 4);
              /*  this.validatorMaxLength("AGIF.L02035", filter.getLgcsAreaCode(), false, 2);
                this.validatorMaxLength("AGIF.L02036", filter.getLgcsAreaName(), false, 8);
                this.validatorMaxLength("AGIF.L02009", filter.getLevelName(), false, 8);
*/

                this.validatorMaxLength("AGIF.L02035", target.getLgcsAreaCode(), false, 2);
                this.validatorMaxLength("AGIF.L02036", target.getLgcsAreaName(), false, 8);
                this.validatorMaxLength("AGIF.L02009", target.getLevelName(), false, 8);
                this.validatorDecimal("AGIF.L06002", target.getLevelValue(), false, 2, 1, 5);
                this.validatorDecimal("AGIF.L06003", target.getMonthAverageSales(), false, 15, 2, 7);
                this.validatorDecimal("AGIF.L06004", target.getMonthAverageGrossProfit(), false, 15, 2, 7);
                this.validatorDecimal("AGIF.L06005", target.getMonthAverageNetProfit(), false, 15, 2, 7);

            }
        }else {
            this.validatorRequired("AGIF.E06001", null);
        }
    }
}
