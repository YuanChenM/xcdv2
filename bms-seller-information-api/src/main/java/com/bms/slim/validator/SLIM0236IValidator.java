package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0236IParam;
import com.bms.slim.bean.param.field.SLIM0236ProducerLaboratoryParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0236IValidator extends DefaultCustomValidator<SLIM0236IParam> {

    @Override
    public void validator(SLIM0236IParam slim0236IParam) {
        List<SLIM0236ProducerLaboratoryParam> paramList = slim0236IParam.getProducerLaboratories();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0236ProducerLaboratoryParam param : paramList) {
                this.validatorRequired("laboratoryId", param.getLaboratoryId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
