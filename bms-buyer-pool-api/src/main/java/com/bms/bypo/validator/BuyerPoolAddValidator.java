package com.bms.bypo.validator;

import com.bms.bypo.bean.param.BuyerPoolRsParam;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;


public class BuyerPoolAddValidator extends DefaultCustomValidator<ArrayList<BuyerPoolRsParam>> {

    @Override
    public void validator(ArrayList<BuyerPoolRsParam> buyerPoolRsParams) {
        if (!CollectionUtils.isEmpty(buyerPoolRsParams)) {
            for (int i = 0; i < buyerPoolRsParams.size(); i++) {
                BuyerPoolRsParam inputParam = buyerPoolRsParams.get(i);
                this.validatorMaxLength("BYPO.L00003", inputParam.getLgcsAreaCode(), true, 2);
                this.validatorMaxLength("BYPO.L00004", inputParam.getLgcsAreaName(), true, 8);
                this.validatorMaxLength("BYPO.L00005", inputParam.getBuyerType(), true, 8);
                this.validatorMaxLength("BYPO.L00061", inputParam.getBuyerTypeName(), true, 32);
                this.validatorMaxLength("BYPO.L00006", inputParam.getBuyerFirstCategory(), true, 8);
                this.validatorMaxLength("BYPO.L00007", inputParam.getBuyerFirstCategoryName(), true, 32);
                this.validatorMaxLength("BYPO.L00008", inputParam.getBuyerSubCategory(), true, 8);
                this.validatorMaxLength("BYPO.L00009", inputParam.getBuyerSubCategoryName(), true, 32);
                this.validatorMaxLength("BYPO.L00010", inputParam.getBuyerPoolCode(), true, 32);
                this.validatorMaxLength("BYPO.L00011", inputParam.getBuyerPoolName(), true, 128);
            }
        } else {
            this.validatorRequired("BYPO.L00002", null);
        }
    }
}
