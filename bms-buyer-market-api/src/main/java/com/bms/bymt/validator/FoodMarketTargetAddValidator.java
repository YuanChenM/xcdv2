package com.bms.bymt.validator;

import com.bms.bymt.bean.param.FoodMarketTargetRsParam;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/16.
 */
public class FoodMarketTargetAddValidator extends DefaultCustomValidator<ArrayList<FoodMarketTargetRsParam>> {
    @Override
    public void validator(ArrayList<FoodMarketTargetRsParam> param) {
        if (!CollectionUtils.isEmpty(param)) {
            List<FoodMarketTargetRsParam> paramList;
            paramList = param;
            for (int i = 0, size = paramList.size(); i < size; i++) {
                this.validatorMaxLength(i + 1, "BYMT.L00013", paramList.get(i).getFoodMarketId(), true, 36);
                this.validatorMaxLength(i + 1, "BYMT.L00014", paramList.get(i).getBuyerName(), true, 16);
                this.validatorMaxLength(i + 1, "BYMT.L00015", paramList.get(i).getProName(), true, 8);

                if (paramList.get(i).getBuyerNum() != null) {
                    this.validatorInteger("BYMT.L00016", paramList.get(i).getBuyerNum(), true, 2147483647, 0, 5);
                }
                if (paramList.get(i).getTradeAmount() != null) {
                    this.validatorDecimal("BYMT.L00017", paramList.get(i).getTradeAmount(), true, 15, 2, 5);
                }

            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }

    }
}
