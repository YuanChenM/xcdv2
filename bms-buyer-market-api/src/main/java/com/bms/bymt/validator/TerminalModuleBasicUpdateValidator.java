package com.bms.bymt.validator;

import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by zhao_chen on 2016/12/15.
 */
public class TerminalModuleBasicUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>>> {

    @Override
    public void validator(ArrayList<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> params) {
        if (CollectionUtils.isNotEmpty(params)) {
            int size = params.size();
            for (int i = 0; i < size; i++) {
                TerminalMarketBasicRsParam filter = params.get(i).getFilter();
                TerminalMarketBasicRsParam target = params.get(i).getTarget();
                this.validatorRequired("BYMT.L00019", filter.getTermMarketId());

                if (StringUtils.isNotEmpty(target.getTermMarketName())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00046", target.getTermMarketName(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getTermMarketCode())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00048", target.getTermMarketCode(), true, 32);
                }
                if (StringUtils.isNotEmpty(target.getTermMarketAddress())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00049", target.getTermMarketAddress(), true, 64);
                }
                if (StringUtils.isNotEmpty(target.getTermMarketLevel())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00047", target.getTermMarketLevel(), true, 2);
                }
                if (StringUtils.isNotEmpty(target.getLgcsAreaCode())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00035", target.getLgcsAreaCode(), true, 2);
                }
                if (StringUtils.isNotEmpty(target.getLgcsAreaName())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00036", target.getLgcsAreaName(), true, 8);
                }
                if (StringUtils.isNotEmpty(target.getZoneCode())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00037", target.getZoneCode(), true, 3);
                }
                if (StringUtils.isNotEmpty(target.getZoneName())) {
                    this.validatorMaxLength(NumberConst.IntDef.INT_ONE, "BYMT.L00038", target.getZoneName(), true, 8);
                }
            }
        } else {
            this.validatorRequired("error.20002", null);
        }

    }
}
