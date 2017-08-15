package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.param.field.SLIM0231ProducerStorageCapacityParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0231IValidator extends DefaultCustomValidator<SLIM0231IParam> {

    @Override
    public void validator(SLIM0231IParam slim0231IParam) {
        List<SLIM0231ProducerStorageCapacityParam> paramList = slim0231IParam.getProducerStorageCapacitys();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0231ProducerStorageCapacityParam param : paramList) {
                this.validatorRequired("materialCapacity",param.getMaterialCapacity());
                this.validatorRequired("productCapacity",param.getProductCapacity());
                this.validatorRequired("warehousePicUrl",param.getWarehousePicUrl());
            }
        }
    }

}
