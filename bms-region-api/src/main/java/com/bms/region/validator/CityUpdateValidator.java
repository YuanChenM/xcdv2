package com.bms.region.validator;

import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.base.consts.NumberConst;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhao_chen on 2016/12/2.
 */
public class CityUpdateValidator extends DefaultCustomValidator<ArrayList<BaseBean<CityRsParam, CityRsParam>>> {
    @Override
    public void validator(ArrayList<BaseBean<CityRsParam, CityRsParam>> paramList) {
        if (paramList != null) {
            HashSet set = new HashSet();
            int size = paramList.size();
            if (size > NumberConst.IntDef.INT_ZERO) {
                for (int i = NumberConst.IntDef.INT_ZERO; i < size; i++) {
                    CityRsParam filter = paramList.get(i).getFilter();
                    CityRsParam target = paramList.get(i).getTarget();
                    if(filter.getCityId() > 0 && target.isDelFlg() == false && (target.getDisableFlg() == null || "1".equals(target.getDisableFlg()))){
                        this.validatorLong(MessageDef.Label.L00019, filter.getCityId(), true, 9223372036854775807L, 0L, 4);
                        this.validatorLong(MessageDef.Label.L00013, target.getProvinceId(), true, 9223372036854775807L, 0L, 4);
                        this.validatorRequired(MessageDef.Label.L00023, target.isDelFlg());
                        if (StringUtils.isNotEmpty(target.getCityCode())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00017, target.getCityCode(), false, 3);
                        }
                        if (StringUtils.isNotEmpty(target.getCityName())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00018, target.getCityName(), false, 8);
                        }
                        if (StringUtils.isNotEmpty(target.getDisableFlg())) {
                            this.validatorMaxLength(i + NumberConst.IntDef.INT_ONE, MessageDef.Label.L00009, target.getDisableFlg(), false, 1);
                        }
                    }
                }
            } else {
                this.validatorRequired(MessageDef.Error.E00011, null);
            }
        }
    }
}
