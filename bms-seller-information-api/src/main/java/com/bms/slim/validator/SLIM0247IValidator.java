package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0247IParam;
import com.bms.slim.bean.param.field.SLIM0247SellerRoleParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0247IValidator extends DefaultCustomValidator<SLIM0247IParam> {

    @Override
    public void validator(SLIM0247IParam slim0247IParam) {
        List<SLIM0247SellerRoleParam> sellerRoles = slim0247IParam.getSellerRoles();
        this.validatorRequired("(请求参数)beans", sellerRoles);
        if (CollectionUtils.isNotEmpty(sellerRoles)) {
            for (SLIM0247SellerRoleParam param : sellerRoles) {
                this.validatorRequired("entitySellerId", param.getEntitySellerId());
                this.validatorRequired("roleId", param.getRoleId());
                this.validatorRequired("roleName", param.getRoleName());
            }
        }
    }

}
