package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0703IParam;
import com.bms.slpd.bean.param.field.SLPD0703IProducerProductParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0703IValidator extends DefaultCustomValidator<SLPD0703IParam> {

    @Override
    public void validator(SLPD0703IParam slpd0703IParam) {
        List<SLPD0703IProducerProductParam> paramList = slpd0703IParam.getProducerProductParams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLPD0703IProducerProductParam param : paramList) {
                this.validatorRequired("producerProductId", param.getProducerProductId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
