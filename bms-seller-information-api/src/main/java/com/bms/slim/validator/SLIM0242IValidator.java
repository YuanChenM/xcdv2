package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0242IParam;
import com.bms.slim.bean.param.wrapper.SlimProducerParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0242IValidator extends DefaultCustomValidator<SLIM0242IParam> {

    @Override
    public void validator(SLIM0242IParam slim0242IParam) {
        List<SlimProducerParam> paramList = slim0242IParam.getBeans();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SlimProducerParam param : paramList) {
                this.validatorRequired("fullName", param.getFullName());
                this.validatorRequired("shortName", param.getShortName());
                this.validatorRequired("provinceName", param.getProvinceName());
                this.validatorRequired("countryCode", param.getCountryCode());
                this.validatorRequired("countryName", param.getCountryName());
                this.validatorRequired("cityCode", param.getCityCode());
                this.validatorRequired("cityName", param.getCityName());
                this.validatorRequired("contactName", param.getContactName());
                this.validatorRequired("tel", param.getTel());
                this.validatorRequired("qq", param.getQq());
                this.validatorRequired("wechat", param.getWechat());
                this.validatorRequired("mobile", param.getMobile());
                this.validatorRequired("producerId", param.getProducerId());
                this.validatorRequired("auditStu", param.getAuditStu());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
