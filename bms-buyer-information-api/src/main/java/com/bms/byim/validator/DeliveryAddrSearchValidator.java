package com.bms.byim.validator;

import com.bms.byim.bean.param.DeliveryAddrRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhao_chen1 on 2016/12/30.
 */
public class DeliveryAddrSearchValidator extends DefaultCustomValidator<DeliveryAddrRsParam> {

    @Override
    public void validator(DeliveryAddrRsParam param) {
        if (param != null) {
            if(StringUtils.isEmpty(param.getBuyerId()) && StringUtils.isEmpty(param.getBuyerCode())){
                throw new BusinessException("BYIM", "BYIM.E00015");
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }


}
