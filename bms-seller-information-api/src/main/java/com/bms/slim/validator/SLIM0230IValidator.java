package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0230IParam;
import com.bms.slim.bean.param.field.SLIM0230ProducerWorkShopParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0230IValidator extends DefaultCustomValidator<SLIM0230IParam> {

    @Override
    public void validator(SLIM0230IParam slim0230IParam) {
        List<SLIM0230ProducerWorkShopParam> paramList = slim0230IParam.getProducerWorkShops();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0230ProducerWorkShopParam param : paramList) {
                this.validatorRequired("workshopId", param.getWorkshopId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
