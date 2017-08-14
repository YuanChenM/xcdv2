package com.bms.linv.validator;

import com.bms.linv.bean.param.LINV0118IParam;
import com.bms.linv.bean.param.LINV0118IProductParam;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by zheng_xu on 2017/5/03.
 */
public class LINV0118IValidator extends DefaultCustomValidator<LINV0118IParam> {

    @Override
    public void validator(LINV0118IParam param) {

        this.validatorMaxLength("adjustCode", param.getAdjustCode(), true, 64);
        this.validatorMaxLength("adjustDate", param.getAdjustDate(), true, 64);
        this.validatorMaxLength("adjustPerson", param.getAdjustPerson(), false, 32);
        this.validatorMaxLength("reasonCode", param.getReasonCode(), true, 8);
        this.validatorMaxLength("reasonName", param.getReasonName(), true, 32);
        if (param.getProductList().size() > 0) {
            for (LINV0118IProductParam productParam : param.getProductList()) {
                this.validatorRequired("slCode", productParam.getSlCode());
                this.validatorRequired("lgcsCode", productParam.getLgcsCode());
                this.validatorRequired("skuCode", productParam.getSkuCode());
                this.validatorRequired("lotNo", productParam.getLotNo());
                this.validatorRequired("unit", productParam.getUnit());
                this.validatorRequired("adjustQty", productParam.getAdjustQty());
                this.validatorRequired("salesLabel", productParam.getSalesLabel());
                this.validatorRequired("fromInventoryStatus", productParam.getFromInventoryStatus());
                this.validatorRequired("toInventoryStatus", productParam.getToInventoryStatus());
            }
        } else {
            this.validatorRequired("productList", null);
        }
    }
}
