package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TerminalMarketNotargetRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
public class TerminalMarketNotargetSaveValidator extends DefaultCustomValidator<ArrayList<TerminalMarketNotargetRsParam>> {
    @Override
    public void validator(ArrayList<TerminalMarketNotargetRsParam> notargetRsParams) {
        List<TerminalMarketNotargetRsParam> marketNotargetList = notargetRsParams;
        if (CollectionUtils.isNotEmpty(marketNotargetList)) {
            int listSize = marketNotargetList.size();
            TerminalMarketNotargetRsParam param = null;
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                param = marketNotargetList.get(i);
                this.validatorRequired("BYMT.L00019", param.getTermMarketId());
                this.validatorRequired("BYMT.L00043", param.getNobuyerName());
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE + i, "BYMT.L00043", param.getNobuyerName(), true, 16);
                if (param.getNobuyerNum() != null) {
                    this.validatorInteger("BYMT.L00050", param.getNobuyerNum(), true, 2147483647, 0, 5);
                }
                if (param.getTradeAmount() != null) {
                    this.validatorDecimal(NumberConst.IntDef.INT_ONE, "BYMT.L00029", param.getTradeAmount(), true, 15, 2, 5);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
