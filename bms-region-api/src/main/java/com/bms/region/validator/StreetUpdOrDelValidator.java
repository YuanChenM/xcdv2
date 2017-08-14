package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.StreetRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by yuan_zhifei on 2016/12/1.
 */
public class StreetUpdOrDelValidator extends DefaultCustomValidator<ArrayList<BaseBean<StreetRsParam, StreetRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<StreetRsParam, StreetRsParam>> rsRequest) {
        if (CollectionUtils.isNotEmpty(rsRequest)) {
            int listSize = rsRequest.size();
            if (listSize > NumberConst.IntDef.INT_ZERO) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    StreetRsParam filter = rsRequest.get(i).getFilter();
                    StreetRsParam target = rsRequest.get(i).getTarget();
                    if (filter.getStreetId() > 0 && target.isDelFlg() == false
                            && (target.getDisableFlg() == null || "1".equals(target.getDisableFlg()))) {
                        this.validatorLong(MessageDef.Label.L00016, filter.getStreetId(), true, 9223372036854775807L,
                            0L, 5);
                        if (StringUtils.isNotEmpty(target.getStreetCode())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00014,
                                target.getStreetCode(), true, 3);
                        }
                        if (StringUtils.isNotEmpty(target.getStreetName())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00015,
                                target.getStreetName(), true, 9);
                        }
                        if (StringUtils.isNotEmpty(target.getDisableFlg())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00015,
                                target.getDisableFlg(), true, 2);
                        }
                    }
                }
            }
        } else {
            this.validatorRequired(MessageDef.Error.E00011, null);
        }
    }
}
