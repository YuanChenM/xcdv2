package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0239IParam;
import com.bms.slim.bean.param.field.SLIM0239ProducerTestEquipmentParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0239IValidator extends DefaultCustomValidator<SLIM0239IParam> {

    @Override
    public void validator(SLIM0239IParam slim0239IParam) {
        List<SLIM0239ProducerTestEquipmentParam> paramList = slim0239IParam.getProducerTestEquipments();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0239ProducerTestEquipmentParam param : paramList) {
                this.validatorRequired("testEqpId", param.getTestEqpId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
