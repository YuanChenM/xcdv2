package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1808IManufacturerParam;
import com.bms.slpd.bean.param.SLPD1808IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1808IValidator extends DefaultCustomValidator<SLPD1808IParam> {

    @Override
    public void validator(SLPD1808IParam slpd1808IParam) {
        List<SLPD1808IManufacturerParam> paramList = slpd1808IParam.getManufacturerParams();
        this.validatorRequired("manufacturerParams", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD1808IManufacturerParam param : paramList) {
                this.validatorRequired("manufacturerProductId", param.getManufacturerProductId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
