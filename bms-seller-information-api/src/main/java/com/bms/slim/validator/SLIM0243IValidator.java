package com.bms.slim.validator;

import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0243IParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0243IValidator extends DefaultCustomValidator<SLIM0243IParam> {

    @Override
    public void validator(SLIM0243IParam slim0243IParam) {
        List<SlimSellerProducer> paramList = slim0243IParam.getSellerProducers();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SlimSellerProducer sellerProducer : paramList) {
                this.validatorRequired("entitySellerId",sellerProducer.getEntitySellerId());
                this.validatorRequired("producerId",sellerProducer.getProducerId());
            }
        }
    }

}
