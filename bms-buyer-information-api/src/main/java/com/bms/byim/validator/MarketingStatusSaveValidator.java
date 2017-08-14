package com.bms.byim.validator;

import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2016/12/9.
 */
public class MarketingStatusSaveValidator extends DefaultCustomValidator<ArrayList<MarketingStatusRsParam>> {
    @Override
    public void validator(ArrayList<MarketingStatusRsParam> statusRsParams) {
        if (CollectionUtils.isNotEmpty(statusRsParams)) {
            int listSize = statusRsParams.size();
            if (listSize > NumberConst.IntDef.INT_ZERO) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    MarketingStatusRsParam statusParam = statusRsParams.get(i);
                    this.validatorRequired("BYIM.L00002", statusParam.getParentId());
                    this.validatorLong("BYIM.L00002", statusParam.getParentId(), true, 9223372036854775807L, 0L, 5);
                    if(!StringUtils.isEmpty(statusParam.getMarketingStatusCode())){
                        this.validatorRequired("BYIM.L00010", statusParam.getMarketingStatusCode());
                        this.validatorMaxLength("BYIM.L00010", statusParam.getMarketingStatusCode(), true, 2);
                    }
                    this.validatorRequired("BYIM.L00011", statusParam.getMarketingStatusName());
                    this.validatorMaxLength("BYIM.L00011", statusParam.getMarketingStatusName(), true, 8);
                }
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
