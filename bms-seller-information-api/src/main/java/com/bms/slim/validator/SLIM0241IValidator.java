package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM024101IParam;
import com.bms.slim.bean.param.SLIM0241IParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0241IValidator extends DefaultCustomValidator<SLIM0241IParam> {

    @Override
    public void validator(SLIM0241IParam slim0241IParam) {
        List<SLIM024101IParam> producers = slim0241IParam.getProducers();
        this.validatorRequired("(请求参数)beans", producers);
        if (CollectionUtils.isNotEmpty(producers)) {
            for (SLIM024101IParam param : producers) {
                this.validatorRequired("fullName", param.getFullName());
                this.validatorRequired("shortName", param.getShortName());
                this.validatorRequired("provinceName", param.getProvinceName());
                this.validatorRequired("countryCode", param.getCountryCode());
                this.validatorRequired("countryName", param.getCountryName());
                this.validatorRequired("cityCode", param.getCityCode());
                this.validatorRequired("cityName", param.getCityName());
                this.validatorRequired("tel", param.getTel());
            }
        }
    }

}
