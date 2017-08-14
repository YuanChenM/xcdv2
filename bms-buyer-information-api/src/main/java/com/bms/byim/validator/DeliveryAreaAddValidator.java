package com.bms.byim.validator;

import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * @param
 * @author zhao_chen
 */
public class DeliveryAreaAddValidator extends DefaultCustomValidator<ArrayList<DeliveryAreaRsParam>> {
    @Override
    public void validator(ArrayList<DeliveryAreaRsParam> result) {
        int size = result.size();
        DeliveryAreaRsParam param;
        if (size > NumberConst.IntDef.INT_ZERO) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                param = result.get(i);
                //必传字段的更改
                this.validatorRequired("BYIM.L00020", param.getCityCode());
                this.validatorRequired("BYIM.L00017", param.getCityName());
                this.validatorRequired("BYIM.L00018", param.getProvinceCode());
                this.validatorRequired("BYIM.L00019", param.getProvinceName());
                this.validatorMaxLength("BYIM.L00013", param.getDeliveryArea(), true, 16);
                this.validatorMaxLength("BYIM.L00014", param.getDeliveryAreaCode(), true, 2);
                this.validatorMaxLength("BYIM.L00015", param.getPassTrafficModel(), true, 32);
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }

    }
}
