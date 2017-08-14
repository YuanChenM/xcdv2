package com.bms.agif.validator;

import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/13.
 */
public class ButlerDemesneDeleteValidator extends DefaultCustomValidator<ArrayList<Long>> {

    @Override
    public void validator(ArrayList<Long> butlerDemesneIdList) {
        if(CollectionUtils.isEmpty(butlerDemesneIdList)) {
            this.validatorRequired("error.20002", null);
        }
    }
}
