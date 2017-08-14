package com.bms.region.validator;

import com.bms.region.bean.param.ProvinceRsParam;
import com.bms.region.constant.MessageDef;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/5.
 */

public class ProvinceAddValidator extends DefaultCustomValidator<ArrayList<ProvinceRsParam>> {

    @Override
    public void validator(ArrayList<ProvinceRsParam> regnProvinceRsParam) {
        if (!CollectionUtils.isEmpty(regnProvinceRsParam)) {
            List<ProvinceRsParam> param = regnProvinceRsParam;
            int paramSize = param.size();
            for (int i = 0; i < paramSize; i++) {
                this.validatorMaxLength(i + 1, MessageDef.Label.L00011, param.get(i).getProvinceCode(), true, 2);
                this.validatorMaxLength(i + 1, MessageDef.Label.L00012, param.get(i).getProvinceName(), true, 8);
            }
        } else {
            this.validatorRequired(MessageDef.Error.E00011, null);
        }

    }
}
