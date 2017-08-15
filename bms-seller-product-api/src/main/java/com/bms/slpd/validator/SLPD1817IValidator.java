package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD1817IParam;
import com.bms.slpd.bean.param.field.SLPD1817IProductParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD1817IValidator extends DefaultCustomValidator<SLPD1817IParam> {

    @Override
    public void validator(SLPD1817IParam slpd1817IParam) {
        List<SLPD1817IProductParam> paramList = slpd1817IParam.getProductParams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD1817IProductParam param : paramList) {
                this.validatorRequired("productId", param.getProductId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
