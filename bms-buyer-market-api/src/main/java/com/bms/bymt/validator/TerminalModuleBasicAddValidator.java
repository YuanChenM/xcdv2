package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by zhao_chen1 on 2016/12/15.
 */
public class TerminalModuleBasicAddValidator extends DefaultCustomValidator<ArrayList<TerminalMarketBasicRsParam>> {

    @Override
    public void validator(ArrayList<TerminalMarketBasicRsParam> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            int size = params.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00046", params.get(i).getTermMarketName(), true, 32);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00049", params.get(i).getTermMarketAddress(), true, 64);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00047", params.get(i).getTermMarketLevel(), true, 2);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00035", params.get(i).getLgcsAreaCode(), true, 2);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00036", params.get(i).getLgcsAreaName(), true, 8);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00037", params.get(i).getZoneCode(), true, 3);
                this.validatorLong(NumberConst.IntDef.INT_ONE, "BYMT.L00075", params.get(i).getZoneId(), true, 9223372036854775806L, 0L, 5);
                this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00038", params.get(i).getZoneName(), true, 8);
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
