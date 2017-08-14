package com.bms.como.validator;

import com.bms.como.bean.param.ComoAddOffShelfRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zhang_jian4 on 2017/4/1.
 */
public class ComoAddOffHandleValidator extends DefaultCustomValidator<ComoAddOffShelfRsParam> {
    @Override
    public void validator(ComoAddOffShelfRsParam addOffShelfRsParam) {
        if (addOffShelfRsParam != null) {
            this.validatorRequired("handleType", addOffShelfRsParam.getHandleType());
            if(StringUtils.isNotEmpty(addOffShelfRsParam.getHandleRemark())){
                this.validatorMaxLength("recordId", addOffShelfRsParam.getHandleRemark(), true, 256);
            }
        }
    }
}
