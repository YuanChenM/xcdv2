package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0201IParam;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0201IValidator extends DefaultCustomValidator<SLIM0201IParam> {

    @Override
    public void validator(SLIM0201IParam slim0201IParam) {
        List<SLIM0201IParam> paramList = slim0201IParam.getProducers();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0201IParam param : paramList) {
                this.validatorRequired("entitySellerId",param.getEntitySellerId());
                this.validatorRequired("fullName",param.getFullName());
                this.validatorRequired("shortName",param.getShortName());
                this.validatorRequired("provinceName",param.getProvinceName());
                this.validatorRequired("countryCode",param.getCountryCode());
                this.validatorRequired("countryName",param.getCountryName());
                this.validatorRequired("cityCode",param.getCityCode());
                this.validatorRequired("cityName",param.getCityName());
                this.validatorRequired("auditStu",param.getAuditStu());
                this.validatorRequired("contactName",param.getContactName());
                this.validatorRequired("tel",param.getTel());
                this.validatorRequired("qq",param.getQq());
                this.validatorRequired("wechat",param.getWechat());
                this.validatorRequired("mobile",param.getMobile());
            }
        }
    }

}
