package com.bms.bymt.validator;

import com.bms.bymt.bean.param.FoodGradeResultParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
public class FoodGradeResultAddValidator extends DefaultCustomValidator<FoodGradeResultParam> {

    @Override
    public void validator(FoodGradeResultParam foodGradeResultParamBaseRequest) {
        FoodGradeResultParam param;
        param = foodGradeResultParamBaseRequest;
        if (param != null) {
            this.validatorRequired("BYMT.L00068", param.getGradeInfoId());
            if (!StringUtils.isEmpty(param.getBuyerLargestPro())) {
                this.validatorRequired("BYMT.L00063", param.getBuyerLargestPro());
            }
            if (param.getBuyerLargestNum() != null) {
                this.validatorRequired("BYMT.L00064", param.getBuyerLargestNum());
            }
            if (!StringUtils.isEmpty(param.getMarketRange())) {
                this.validatorRequired("BYMT.L00067", param.getMarketRange());
            }
            if (!StringUtils.isEmpty(param.getAveragePrice())) {
                this.validatorRequired("BYMT.L00065", param.getAveragePrice());
            }
            if (!StringUtils.isEmpty(param.getFoodMarketLevel())) {
                this.validatorRequired("BYMT.L00066", param.getFoodMarketLevel());
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
