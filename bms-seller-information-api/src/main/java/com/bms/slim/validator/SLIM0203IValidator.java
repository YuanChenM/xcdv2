package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0203IParam;
import com.bms.slim.bean.param.wrapper.SlimSellerProducerParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0203IValidator extends DefaultCustomValidator<SLIM0203IParam> {

    @Override
    public void validator(SLIM0203IParam slim0203IParam) {
        List<SlimSellerProducerParam> paramList = slim0203IParam.getBeans();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SlimSellerProducerParam param : paramList) {
                if(!param.getDelFlg()){
                    this.validatorRequired("fullName",param.getFullName());
                    this.validatorRequired("shortName",param.getShortName());
                    this.validatorRequired("provinceName",param.getProvinceName());
                    this.validatorRequired("countryCode",param.getCountryCode());
                    this.validatorRequired("countryName",param.getCountryName());
                    this.validatorRequired("cityCode",param.getCityCode());
                    this.validatorRequired("cityName",param.getCityName());
                    this.validatorRequired("contactName",param.getContactName());
                    this.validatorRequired("tel",param.getTel());
                    this.validatorRequired("qq",param.getQq());
                    this.validatorRequired("wechat",param.getWechat());
                    this.validatorRequired("mobile",param.getMobile());
                }
                this.validatorRequired("entitySellerId",param.getEntitySellerId());
                this.validatorRequired("producerId",param.getProducerId());
                this.validatorRequired("contactId",param.getContactId());
                this.validatorRequired("auditStu",param.getAuditStu());
                this.validatorRequired("version",param.getVersion());
                this.validatorMaxLength("updId", param.getUpdId(), true, 32);
            }
        }
    }

}
