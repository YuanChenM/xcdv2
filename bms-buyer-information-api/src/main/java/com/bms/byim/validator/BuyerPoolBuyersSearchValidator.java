package com.bms.byim.validator;

import com.bms.byim.bean.param.BuyerPoolBuyersRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2016/12/30.
 */
public class BuyerPoolBuyersSearchValidator extends DefaultCustomValidator<BuyerPoolBuyersRsParam> {
    @Override
    public void validator(BuyerPoolBuyersRsParam searchParam) {
        this.validatorMaxLength("BYIM.L00054", searchParam.getBuyerPoolCode(), true, 16);
    }
}
