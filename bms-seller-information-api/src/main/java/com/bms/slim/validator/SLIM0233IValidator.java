package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0233IParam;
import com.bms.slim.bean.param.field.SLIM0233ProducerStorageCapacityParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0233IValidator extends DefaultCustomValidator<SLIM0233IParam> {

    @Override
    public void validator(SLIM0233IParam slim0233IParam) {
        List<SLIM0233ProducerStorageCapacityParam> paramList = slim0233IParam.getProducerStorageCapacitys();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0233ProducerStorageCapacityParam param : paramList) {
                this.validatorRequired("storageCapacityId", param.getStorageCapacityId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
