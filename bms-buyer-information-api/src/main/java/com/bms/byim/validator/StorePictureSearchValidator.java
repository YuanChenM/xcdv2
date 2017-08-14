package com.bms.byim.validator;

import com.bms.byim.bean.param.StorePictureRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by yuan_zhifei on 2016/12/30.
 */
public class StorePictureSearchValidator extends DefaultCustomValidator<StorePictureRsParam> {
    @Override
    public void validator(StorePictureRsParam storePictureRsParam) {
        if (storePictureRsParam != null) {
            if (StringUtils.isEmpty(storePictureRsParam.getBuyerId()) && StringUtils.isEmpty(storePictureRsParam.getBuyerCode())) {
                throw new BusinessException("BYIM", "BYIM.E00015");
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
