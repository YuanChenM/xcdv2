package com.bms.slpd.validator;

import com.bms.slpd.bean.param.SLPD0702IParam;
import com.bms.slpd.bean.param.wrapper.SlpdProductProducerParam;
import com.bms.slpd.constant.MessageConstant;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLPD0702IValidator extends DefaultCustomValidator<SLPD0702IParam> {
    @Override
    public void validator(SLPD0702IParam slpd0702IParam) {
        /*List<SlpdProductProducerParam> paramList = slpd0702IParam.getProductProducerList();
        this.validatorRequired(MessageConstant.Label.Params, paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SlpdProductProducerParam param : paramList) {
                this.validatorMaxLength(MessageConstant.Label.ProductId, param.getProductId(), true, 32);
                this.validatorRequired(MessageConstant.Label.ProducerId, param.getProducerId());
                this.validatorMaxLength(MessageConstant.Label.ProducerName, param.getProducerName(), true, 256);
                this.validatorMaxLength("producerCode", param.getProducerCode(), true, 16);
                this.validatorMaxLength(MessageConstant.Label.CrtId, param.getCrtId(), true, 32);
            }
        }*/
    }
}
