package com.bms.byim.validator;

import com.bms.byim.bean.param.DeliveryAreaCodeRsParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2017/5/4.
 */
public class DeliveryAreaCodeSearchValidator extends DefaultCustomValidator<DeliveryAreaCodeRsParam> {
    @Override
    public void validator(DeliveryAreaCodeRsParam rsParam) {
        this.validatorRequired("BYIM.L00051", rsParam.getBuyerId());
        this.validatorRequired("BYIM.L00019", rsParam.getProvinceName());
        this.validatorRequired("BYIM.L00017", rsParam.getCityName());
        this.validatorRequired("BYIM.L00043", rsParam.getDistrictName());
        this.validatorRequired("BYIM.L00105", rsParam.getDeliveryAddr());
    }
}
