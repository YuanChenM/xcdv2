package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.FoodMarketTargetRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2016/12/16.
 */
public class FoodMarketTargetUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<FoodMarketTargetRsParam, FoodMarketTargetRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<FoodMarketTargetRsParam, FoodMarketTargetRsParam>> param) {
        if (!CollectionUtils.isEmpty(param)) {
            for (int i = 0, sizes = param.size(); i < sizes; i++) {
                this.validatorLong(i + 1, "BYMT.L00018", param.get(i).getFilter().getTargetId(), true, 9223372036854775806L, 0L, 5);
                if (!StringUtils.isEmpty(param.get(i).getTarget().getBuyerName())) {
                    this.validatorMaxLength(i + 1, "BYMT.L00014", param.get(i).getTarget().getBuyerName(), true, 16);
                }
                if (!StringUtils.isEmpty(param.get(i).getTarget().getProName())) {
                    this.validatorMaxLength(i + 1, "BYMT.L00015", param.get(i).getTarget().getProName(), true, 8);
                }

                if (param.get(i).getTarget().getBuyerNum() != null) {
                    this.validatorInteger(i + 1, "BYMT.L00016", param.get(i).getTarget().getBuyerNum(), true, 2147483647, 0, 5);
                }
                if (param.get(i).getTarget().getTradeAmount() != null) {
                    this.validatorDecimal(i + 1, "BYMT.L00017", param.get(i).getTarget().getTradeAmount(), true, 15, 2, 5);
                }
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
