package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0119IParam;
import com.bms.slim.bean.param.field.SLIM0119SellerBusinessTeamParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0119IValidator extends DefaultCustomValidator<SLIM0119IParam> {

    @Override
    public void validator(SLIM0119IParam slim0119IParam) {
        List<SLIM0119SellerBusinessTeamParam> paramList = slim0119IParam.getBusinessTeams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0119SellerBusinessTeamParam param : paramList) {
                this.validatorRequired("entitySellerId",param.getEntitySellerId());
                this.validatorRequired("positionType",param.getPositionType());
                this.validatorRequired("name",param.getName());
                this.validatorRequired("age",param.getAge());
                this.validatorRequired("educationalLevel",param.getEducationalLevel());
                this.validatorRequired("contactWay",param.getContactWay());
                this.validatorRequired("avatarUrl",param.getAvatarUrl());
            }
        }
    }

}
