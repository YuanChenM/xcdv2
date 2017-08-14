package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.DistrictRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhao_chen on 2016/12/2.
 */
public class DistrictUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<DistrictRsParam, DistrictRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<DistrictRsParam, DistrictRsParam>> paramList) {
        if (paramList != null) {
            HashSet set = new HashSet();
            int size = paramList.size();
            if (size > NumberConst.IntDef.INT_ZERO) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                    DistrictRsParam filter = paramList.get(i).getFilter();
                    DistrictRsParam target = paramList.get(i).getTarget();
                    this.validatorLong(MessageDef.Label.L00022, filter.getDistrictId(), true, 9223372036854775807L, 0L, 4);

                    this.validatorRequired(MessageDef.Label.L00023, target.isDelFlg());
                    if (StringUtils.isNotEmpty(target.getDistrictCode())) {
                        this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00020, target.getDistrictCode(), false, 3);
                    }
                    if (StringUtils.isNotEmpty(target.getDistrictName())) {
                        this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00021, target.getDistrictName(), false, 8);
                    }
                    if (StringUtils.isNotEmpty(target.getDisableFlg())) {
                        this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00009, target.getDisableFlg(), false, 1);
                    }
                }
            } else {
                this.validatorRequired("202", null);
            }
        }
    }
}
