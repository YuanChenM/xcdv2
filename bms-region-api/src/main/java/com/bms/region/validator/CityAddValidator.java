package com.bms.region.validator;

import com.bms.region.bean.param.CityRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhao_chen on 2016/12/2.
 */
public class CityAddValidator extends DefaultCustomValidator<ArrayList<CityRsParam>> {
    @Override
    public void validator(ArrayList<CityRsParam> paramList) {
        if (paramList != null) {
            HashSet set = new HashSet();
            int size = paramList.size();
            CityRsParam param;
            if (CollectionUtils.isNotEmpty(paramList)) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                    param = paramList.get(i);
                    //长度限制  L00019
                    this.validatorLong(MessageDef.Label.L00013, paramList.get(i).getProvinceId(), true, 9223372036854775807L, 0L, 4);
                    this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00017, param.getCityCode().trim(), true, 3);
                    this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00018, param.getCityName().trim(), true, 8);
                    String code = param.getCityCode() + param.getProvinceId();
                    if (set.contains(code)) {
                        this.validatorRequired(MessageDef.Error.E00012, null);
                    } else {
                        set.add(code);
                    }
                }
            } else {
                this.validatorRequired(MessageDef.Error.E00011, null);
            }

        }

    }

}
