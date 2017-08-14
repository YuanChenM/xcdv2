package com.bms.byim.validator;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2016/12/9.
 */
public class MarketingStatusModifyValidator extends DefaultCustomValidator<ArrayList<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> baseBeanList) {
        if (CollectionUtils.isNotEmpty(baseBeanList)) {
            int listSize = baseBeanList.size();
            if (listSize > NumberConst.IntDef.INT_ZERO) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    MarketingStatusRsParam filter = baseBeanList.get(i).getFilter();
                    MarketingStatusRsParam target = baseBeanList.get(i).getTarget();
                    this.validatorRequired("BYIM.L00007", filter.getMarketingStatusId());
                    if (StringUtils.isNotEmpty(target.getMarketingStatusCode())) {
                        this.validatorMaxLength("BYIM.L00010", target.getMarketingStatusCode(), true, 2);
                    }
                    if (StringUtils.isNotEmpty(target.getMarketingStatusName())) {
                        this.validatorMaxLength("BYIM.L00011", target.getMarketingStatusName(), true, 8);
                    }
                }
            }
        } else {
            this.validatorRequired("BYIM.L00009", null);
        }
    }
}
