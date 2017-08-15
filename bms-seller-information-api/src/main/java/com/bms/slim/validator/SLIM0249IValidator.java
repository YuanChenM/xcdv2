package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0249IParam;
import com.bms.slim.bean.param.field.SLIM0249SellerRoleParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0249IValidator extends DefaultCustomValidator<SLIM0249IParam> {

    @Override
    public void validator(SLIM0249IParam slim0249IParam) {
        List<SLIM0249SellerRoleParam> sellerRoles = slim0249IParam.getSellerRoles();
        this.validatorRequired("(请求参数)beans", sellerRoles);
        if (CollectionUtils.isNotEmpty(sellerRoles)) {
            for (SLIM0249SellerRoleParam param : sellerRoles) {
                this.validatorRequired("sellerRoleId", param.getSellerRoleId());
                this.validatorRequired("version",param.getVersion());
            }
        }
    }

}
