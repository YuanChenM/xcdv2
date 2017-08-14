package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerIntroduceRsParam;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/3.
 */
public class ButlerIntroduceAddValidator extends DefaultCustomValidator<ArrayList<ButlerIntroduceRsParam>> {

    @Override
    public void validator(ArrayList<ButlerIntroduceRsParam> paramList) {
        if (!CollectionUtils.isEmpty(paramList)) {
            for (int i = 0, size = paramList.size(); i < size; i++) {
                this.validatorMaxLength("AGIF.L03002", paramList.get(i).getButlerId(), true, 36);
                this.validatorMaxLength("AGIF.L03019", paramList.get(i).getIntroduceType(), true, 1);
                this.validatorMaxLength("AGIF.L03020", paramList.get(i).getIntroduceDetail(), true, 128);
            }
        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
