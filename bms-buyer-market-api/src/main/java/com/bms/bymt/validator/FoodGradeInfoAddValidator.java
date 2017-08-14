package com.bms.bymt.validator;

import com.bms.bymt.bean.param.FoodGradeInfoParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/19.
 */
public class FoodGradeInfoAddValidator extends DefaultCustomValidator<FoodGradeInfoParam> {
    @Override
    public void validator(FoodGradeInfoParam foodGradeInfoParamBaseRequest) {
        FoodGradeInfoParam param;
        param = foodGradeInfoParamBaseRequest;
        if (param != null) {
            this.validatorRequired("BYMT.L00013", param.getFoodMarketId());
            if (param.getLargestMarletNum() != null) {
                this.validatorRequired("BYMT.L00057", param.getLargestMarletNum());
            }
            if (!StringUtils.isEmpty(param.getAveragePrice())) {
                this.validatorRequired("BYMT.L00061", param.getAveragePrice());
            }
            if (!StringUtils.isEmpty(param.getLargestMarketPro())) {
                this.validatorRequired("BYMT.L00056", param.getLargestMarketPro());
            }
            if (!StringUtils.isEmpty(param.getLargestMarketStandard())) {
                this.validatorRequired("BYMT.L00058", param.getLargestMarketStandard());
            }
            if (!StringUtils.isEmpty(param.getMarketCoverArea())) {
                this.validatorRequired("BYMT.L00059", param.getMarketCoverArea());
            }
            if (!StringUtils.isEmpty(param.getMarketCoverAreaStandard())) {
                this.validatorRequired("BYMT.L00060", param.getMarketCoverAreaStandard());
            }
            if (!StringUtils.isEmpty(param.getStandardPrice())) {
                this.validatorRequired("BYMT.L00062", param.getStandardPrice());
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
