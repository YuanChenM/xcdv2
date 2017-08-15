package com.bms.slim.validator;

import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.param.SLIM0204IParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0204IValidator extends DefaultCustomValidator<SLIM0204IParam> {

    @Override
    public void validator(SLIM0204IParam slim0204IParam) {
//        List<SlimSellerProducer> paramList = slim0204IParam.getSellerProducers();
//        this.validatorRequired("(请求参数)beans", paramList);
//        if (CollectionUtils.isNotEmpty(paramList)) {
//            for (SlimSellerProducer sellerProducer : paramList) {
//                this.validatorRequired("entitySellerId",sellerProducer.getEntitySellerId());
//                this.validatorRequired("producerId",sellerProducer.getProducerId());
//                this.validatorMaxLength("crtId", sellerProducer.getCrtId(), true, NumberConst.IntDef.INT_THIRTY_TWO);
//            }
//        }
    }

}
