package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0228IParam;
import com.bms.slim.bean.param.field.SLIM0228ProducerWorkShopParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0228IValidator extends DefaultCustomValidator<SLIM0228IParam> {

    @Override
    public void validator(SLIM0228IParam slim0228IParam) {
        List<SLIM0228ProducerWorkShopParam> paramList = slim0228IParam.getProducerWorkShops();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0228ProducerWorkShopParam param : paramList) {
                this.validatorRequired("sellerRoleId",param.getSellerRoleId());
                this.validatorRequired("workshopName",param.getWorkshopName());
                this.validatorRequired("productionProduct",param.getProductionProduct());
                this.validatorRequired("proccessFlowCharacter",param.getProccessFlowCharacter());
                this.validatorRequired("workshopPicUrl",param.getWorkshopPicUrl());
            }
        }
    }

}
