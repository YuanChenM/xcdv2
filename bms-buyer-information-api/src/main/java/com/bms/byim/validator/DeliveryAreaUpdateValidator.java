package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhao_chen1 on 2016/12/9.
 */
public class DeliveryAreaUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> paramList) {
        //唯一性check
        int size = paramList.size();
        if (size > NumberConst.IntDef.INT_ZERO) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                DeliveryAreaRsParam filter = paramList.get(i).getFilter();
                DeliveryAreaRsParam target = paramList.get(i).getTarget();
                if (target.getDelFlg() == false) {
                    this.validatorRequired("BYIM.L00020", filter.getCityCode());
                    this.validatorRequired("BYIM.L00018", filter.getProvinceCode());
                    this.validatorRequired("BYIM.L00020", target.getCityCode());
                    this.validatorRequired("BYIM.L00018", target.getProvinceCode());
                }
                this.validatorRequired("BYIM.L00021", filter.getDeliveryAreaId());
                this.validatorMaxLength("BYIM.L00013", target.getDeliveryArea(), false, 16);
                this.validatorMaxLength("BYIM.L00014", target.getDeliveryAreaCode(), false, 2);
                this.validatorMaxLength("BYIM.L00015", target.getPassTrafficModel(), false, 32);

            }
        }

    }
}
