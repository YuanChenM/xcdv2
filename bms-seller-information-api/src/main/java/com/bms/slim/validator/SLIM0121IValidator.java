package com.bms.slim.validator;

import com.bms.slim.bean.param.SLIM0121IParam;
import com.bms.slim.bean.param.field.SLIM0121SellerBusinessTeamParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

public class SLIM0121IValidator extends DefaultCustomValidator<SLIM0121IParam> {

    @Override
    public void validator(SLIM0121IParam slim0121IParam) {
        List<SLIM0121SellerBusinessTeamParam> paramList = slim0121IParam.getBusinessTeams();
        this.validatorRequired("(请求参数)beans", paramList);
        if (CollectionUtils.isNotEmpty(paramList)) {
            for (SLIM0121SellerBusinessTeamParam param : paramList) {
                this.validatorRequired("sbtId", param.getSbtId());
                this.validatorRequired("version", param.getVersion());
            }
        }
    }

}
