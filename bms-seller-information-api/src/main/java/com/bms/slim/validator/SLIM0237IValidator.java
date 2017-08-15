package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0237IParam;
import com.bms.slim.bean.param.field.SLIM0237ProducerTestEquipmentParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0237IValidator extends DefaultCustomValidator<SLIM0237IParam> {

    @Override
    public void validator(SLIM0237IParam slim0237IParam) {
        List<SLIM0237ProducerTestEquipmentParam> paramList = slim0237IParam.getProducerTestEquipments();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0237ProducerTestEquipmentParam param : paramList) {
                this.validatorRequired("sellerRoleId",param.getSellerRoleId());
                this.validatorRequired("testEqpName",param.getTestEqpName());
                this.validatorRequired("testEqpUse",param.getTestEqpUse());
                this.validatorRequired("testEqpPicUrl",param.getTestEqpPicUrl());
            }
        }
    }

}
