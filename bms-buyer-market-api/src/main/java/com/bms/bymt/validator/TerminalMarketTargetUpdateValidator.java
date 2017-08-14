package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketTargetRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/15.
 */
public class TerminalMarketTargetUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<TerminalMarketTargetRsParam, TerminalMarketTargetRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<TerminalMarketTargetRsParam, TerminalMarketTargetRsParam>> baseBeans) {

        if (!CollectionUtils.isEmpty(baseBeans)) {

            for (int i = 0, sizes = baseBeans.size(); i < sizes; i++) {
                this.validatorLong(i + 1, "BYMT.L00018", baseBeans.get(i).getFilter().getTargetId(), true, 9223372036854775806L, 0L, 5);

                if (!StringUtils.isEmpty(baseBeans.get(i).getTarget().getBuyerName())) {
                    this.validatorMaxLength(i + 1, "BYMT.L00014", baseBeans.get(i).getTarget().getBuyerName(), true, 16);
                }
                if (!StringUtils.isEmpty(baseBeans.get(i).getTarget().getProName())) {
                    this.validatorMaxLength(i + 1, "BYMT.L00015", baseBeans.get(i).getTarget().getProName(), true, 16);
                }

                if (baseBeans.get(i).getTarget().getBuyerNum() != null) {
                    this.validatorInteger(i + 1, "BYMT.L00016", baseBeans.get(i).getTarget().getBuyerNum(), true, 2147483647, 0, 5);
                }
                if (baseBeans.get(i).getTarget().getTradeAmount() != null) {
                    this.validatorDecimal(i + 1, "BYMT.L00017", baseBeans.get(i).getTarget().getTradeAmount(), true, 15, 2, 5);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }

    }
}
