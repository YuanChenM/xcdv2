package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketNotargetRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
public class TerminalMarketNotargetModifyValidator extends DefaultCustomValidator<ArrayList<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>> baseBeans) {
        List<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>> marketNotargetParams = baseBeans;
        if (CollectionUtils.isNotEmpty(marketNotargetParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < marketNotargetParams.size(); i++) {
                TerminalMarketNotargetRsParam filter = marketNotargetParams.get(i).getFilter();
                TerminalMarketNotargetRsParam target = marketNotargetParams.get(i).getTarget();
                this.validatorRequired("BYMT.L00051", filter.getNotargetId());
                if (target.getNobuyerNum() != null) {
                    this.validatorInteger("BYMT.L00050", target.getNobuyerNum(), true, 2147483647, 0, 5);
                }
                if (target.getTradeAmount() != null) {
                    this.validatorDecimal(NumberConst.IntDef.INT_ONE, "BYMT.L00029", target.getTradeAmount(), true, 15, 2, 5);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
