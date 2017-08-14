package com.bms.bymt.validator;

import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class FoodMarketModuleBasicAddValidator extends DefaultCustomValidator<ArrayList<MarketFoodModuleBasicRsParam>> {

    @Override
    public void validator(ArrayList<MarketFoodModuleBasicRsParam> params) {

        if (params != null) {
            int size = params.size();
            for (int i = 0; i < size; i++) {
                //message需要定义
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00030", params.get(i).getFoodMarketName(), true, 32);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00032", params.get(i).getFoodMarketAddress(), true, 64);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00033", params.get(i).getFoodMarketLevel(), true, 2);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00034", params.get(i).getScopeType(), true, 4);
                this.validatorLong(NumberConst.IntDef.INT_ONE, "BYMT.L00075", params.get(i).getLgcsAreaId(), true, 9223372036854775806L, 0L, 5);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00035", params.get(i).getLgcsAreaCode(), true, 2);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00036", params.get(i).getLgcsAreaName(), true, 8);
                this.validatorLong(NumberConst.IntDef.INT_ONE, "BYMT.L00076", params.get(i).getZoneId(), true, 9223372036854775806L, 0L, 5);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00037", params.get(i).getZoneCode(), true, 3);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00038", params.get(i).getZoneName(), true, 8);
                this.validatorLong(NumberConst.IntDef.INT_ONE, "BYMT.L00077", params.get(i).getDistrictId(), true, 9223372036854775806L, 0L, 5);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00039", params.get(i).getDistrictCode(), true, 4);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00040", params.get(i).getDistrictName(), true, 8);
            }
        } else {
            this.validatorRequired("BYMT.L00028", null);
        }
    }
}
