package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0107IParam;
import com.bms.slim.bean.param.field.SLIM0107SellerManagementTeamParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0107IValidator extends DefaultCustomValidator<SLIM0107IParam> {

    @Override
    public void validator(SLIM0107IParam slim0107IParam) {
        List<SLIM0107SellerManagementTeamParam> paramList = slim0107IParam.getManagementTeams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0107SellerManagementTeamParam param : paramList) {
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
