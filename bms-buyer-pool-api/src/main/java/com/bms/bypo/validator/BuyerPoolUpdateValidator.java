package com.bms.bypo.validator;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.BuyerPoolRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;


public class BuyerPoolUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> updateParam) {
        if (!CollectionUtils.isEmpty(updateParam)) {
            for (int i = 0; i < updateParam.size(); i++) {
                if (updateParam.get(i).getFilter() != null) {
                    BuyerPoolRsParam filter = updateParam.get(i).getFilter();
                    this.validatorRequired("BYPO.L00014", StringUtils.toString(filter.getBuyerPoolId()));
                } else {
                    this.validatorRequired("BYPO.L00012", null);
                }
                if (updateParam.get(i).getTarget() != null) {
                    BuyerPoolRsParam target = updateParam.get(i).getTarget();
                    if (!StringUtils.isEmpty(target.getLgcsAreaCode()) || !StringUtils.isEmpty(target.getLgcsAreaName())) {
                        this.validatorMaxLength("BYPO.L00003", target.getLgcsAreaCode(), true, 2);
                        this.validatorMaxLength("BYPO.L00004", target.getLgcsAreaName(), true, 8);
                    }
                    if (!StringUtils.isEmpty(target.getBuyerType())) {
                        this.validatorMaxLength("BYPO.L00005", target.getBuyerType(), true, 8);
                        this.validatorMaxLength("BYPO.L00061", target.getBuyerTypeName(), true, 32);
                    }
                    if (!StringUtils.isEmpty(target.getBuyerFirstCategory()) || !StringUtils.isEmpty(target.getBuyerFirstCategoryName())) {
                        this.validatorMaxLength("BYPO.L00006", target.getBuyerFirstCategory(), true, 8);
                        this.validatorMaxLength("BYPO.L00007", target.getBuyerFirstCategoryName(), true, 32);
                    }
                    if (!StringUtils.isEmpty(target.getBuyerSubCategory()) || !StringUtils.isEmpty(target.getBuyerSubCategoryName())) {
                        this.validatorMaxLength("BYPO.L00008", target.getBuyerSubCategory(), true, 8);
                        this.validatorMaxLength("BYPO.L00009", target.getBuyerSubCategoryName(), true, 32);
                    }
                    if (!StringUtils.isEmpty(target.getBuyerPoolCode())) {
                        this.validatorMaxLength("BYPO.L00010", target.getBuyerPoolCode(), true, 32);
                    }
                    if (!StringUtils.isEmpty(target.getBuyerPoolName())) {
                        this.validatorMaxLength("BYPO.L00011", target.getBuyerPoolName(), true, 128);
                    }

                } else {
                    this.validatorRequired("BYPO.L00013", null);
                }
            }
        } else {
            this.validatorRequired("BYPO.L00002", null);
        }
    }
}
