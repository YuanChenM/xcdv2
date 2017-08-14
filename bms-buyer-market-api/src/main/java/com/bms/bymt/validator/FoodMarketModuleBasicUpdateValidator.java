package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketFoodModuleBasicRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class FoodMarketModuleBasicUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> result) {

        if (CollectionUtils.isNotEmpty(result)) {
            List<BaseBean<MarketFoodModuleBasicRsParam, MarketFoodModuleBasicRsParam>> params;
            if (result != null) {
                params = result;
                int size = params.size();
                for (int i = 0; i < size; i++) {
                    MarketFoodModuleBasicRsParam filter = params.get(i).getFilter();
                    MarketFoodModuleBasicRsParam target = params.get(i).getTarget();
                    //message需要定义
                    this.validatorRequired("BYMT.L00013", filter.getFoodMarketId());

                    if (StringUtils.isNotEmpty(target.getFoodMarketName())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00030", target.getFoodMarketName(), false, 32);
                    }
                    if (StringUtils.isNotEmpty(target.getFoodMarketCode())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00031", target.getFoodMarketCode(), false, 32);
                    }
                    if (StringUtils.isNotEmpty(target.getFoodMarketAddress())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00032", target.getFoodMarketAddress(), false, 64);
                    }
                    if (StringUtils.isNotEmpty(target.getFoodMarketLevel())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00033", target.getFoodMarketLevel(), false, 2);
                    }
                    if (StringUtils.isNotEmpty(target.getLgcsAreaCode())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00035", target.getLgcsAreaCode(), false, 2);
                    }
                    if (StringUtils.isNotEmpty(target.getLgcsAreaName())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00036", target.getLgcsAreaName(), false, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getZoneCode())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00037", target.getZoneCode(), false, 3);
                    }
                    if (StringUtils.isNotEmpty(target.getZoneName())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00038", target.getZoneName(), false, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getDistrictCode())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00039", target.getDistrictCode(), false, 4);
                    }
                    if (StringUtils.isNotEmpty(target.getDistrictName())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00040", target.getDistrictName(), false, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getScopeType())) {
                        this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00034", target.getScopeType(), false, 4);
                    }
                }
            } else {
                this.validatorRequired("BYMT.L00028", null);
            }
        }
    }
}
