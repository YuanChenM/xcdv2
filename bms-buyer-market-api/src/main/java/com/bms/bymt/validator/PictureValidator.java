package com.bms.bymt.validator;

import com.bms.bymt.bean.param.MarketPictureRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
public class PictureValidator extends DefaultCustomValidator<MarketPictureRsParam> {

    @Override
    public void validator(MarketPictureRsParam param) {
        if (param != null) {
            this.validatorMaxLength("BYMT.L00012", param.getMarketId(), true, 36);
        } else {
            this.validatorRequired("BYMT.L00012", null);
        }
    }
}
