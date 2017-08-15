package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0116IParam;
import com.bms.slim.bean.param.field.SLIM0244IContactParam;
import com.bms.slim.bean.param.field.SLIM0116ISellerContractPermissionParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0116IValidator extends DefaultCustomValidator<SLIM0116IParam> {


    @Override
    public void validator(SLIM0116IParam slim0116IParam) {
        List<SLIM0116ISellerContractPermissionParam> params = slim0116IParam.getSellerContractPermissionParams();
        this.validatorRequired("sellerContractPermissionParams", params);
        if (CollectionUtils.isNotEmpty(params)) {
            for (SLIM0116ISellerContractPermissionParam permissionParam : params) {
                this.validatorRequired("entitySellerId", permissionParam.getEntitySellerId());
                this.validatorMaxLength("sellerFullName", permissionParam.getSellerFullName(), true, 32);
                this.validatorMaxLength("countryCode", permissionParam.getCountryCode(), true, 2);
                this.validatorMaxLength("countryName", permissionParam.getCityName(), true, 32);
                this.validatorMaxLength("provinceCode", permissionParam.getProvinceCode(), true, 2);
                this.validatorMaxLength("provinceName", permissionParam.getProvinceName(), true, 8);
                this.validatorMaxLength("cityCode", permissionParam.getCityCode(), true, 4);
                this.validatorMaxLength("cityName", permissionParam.getCityName(), true, 8);
                this.validatorMaxLength("businessAddress", permissionParam.getBusinessAddress(), true, 256);
                this.validatorMaxLength("payeeName", permissionParam.getPayeeName(), true, 32);
                this.validatorMaxLength("payeeBank", permissionParam.getPayeeBank(), true, 32);
                this.validatorMaxLength("bankAccount", permissionParam.getBankAccount(), true, 32);
                this.validatorMaxLength("expressAddress", permissionParam.getExpressAddress(), true, 128);
            }

        }

    }
}
